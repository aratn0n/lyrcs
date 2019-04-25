package com.lyrcs.presentation.ui.searchlyrics

import androidx.lifecycle.MutableLiveData
import com.lyrcs.domain.common.ResultState
import com.lyrcs.domain.usecase.SearchTrackUseCase
import com.lyrcs.presentation.display.SearchResultDisplay
import com.lyrcs.presentation.mapper.TrackMapper
import com.lyrcs.presentation.ui.base.BaseViewModel
import com.lyrcs.presentation.ui.base.SingleLiveEvent
import javax.inject.Inject

class ViewModelSearchTracks @Inject constructor(
    private val searchTrackUseCase: SearchTrackUseCase,
    private val trackMapper: TrackMapper
) : BaseViewModel() {
    private val searchTracksLiveData = SingleLiveEvent<ResultState<List<SearchResultDisplay>>>()

    fun getSearchTracksLiveData() = searchTracksLiveData

    fun searchLyrics(trackName: String, artistName: String) {
        disposable = searchTrackUseCase.searchTrack(trackName, artistName)
            .subscribe(
                { tracks ->
                    val display = tracks.map { track -> trackMapper.transform(track) }
                    searchTracksLiveData.postValue(ResultState.Success(display))
                }, { error ->
                    searchTracksLiveData.postValue(ResultState.Error(error, null ))
                })
        disposable.track()
    }
}