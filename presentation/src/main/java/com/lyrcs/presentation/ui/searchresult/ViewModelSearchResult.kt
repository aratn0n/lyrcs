package com.lyrcs.presentation.ui.searchresult

import androidx.lifecycle.MutableLiveData
import com.lyrcs.domain.common.ResultState
import com.lyrcs.domain.usecase.GetLyricsUseCase
import com.lyrcs.domain.usecase.SearchTrackUseCase
import com.lyrcs.presentation.display.LyricsDisplay
import com.lyrcs.presentation.display.SearchResultDisplay
import com.lyrcs.presentation.mapper.LyricsMapper
import com.lyrcs.presentation.mapper.TrackMapper
import com.lyrcs.presentation.ui.base.BaseViewModel
import com.lyrcs.presentation.ui.base.SingleLiveEvent
import javax.inject.Inject

class ViewModelSearchResult @Inject constructor(
    private val getLyricsUseCase: GetLyricsUseCase,
    private val lyricsMapper: LyricsMapper
) : BaseViewModel() {

    private val searchLyricsLiveData = SingleLiveEvent<ResultState<LyricsDisplay>>()

    fun getSearchLyricsLiveData() = searchLyricsLiveData

    fun getLyrics(trackId: String,
                  trackName: String,
                  artistName: String) {
        searchLyricsLiveData.postValue(ResultState.Loading(null))
        getLyricsUseCase.getLyrics(trackId)
            .subscribe( {
                    lyrics -> searchLyricsLiveData.postValue(
                ResultState.Success(lyricsMapper.transform(trackName,
                    artistName,
                    lyrics)
                ))
            }, { error -> searchLyricsLiveData.postValue(ResultState.Error(error, null)) }
        ).track()
    }
}