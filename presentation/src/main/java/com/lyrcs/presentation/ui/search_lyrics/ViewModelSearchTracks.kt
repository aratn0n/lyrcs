package com.lyrcs.presentation.ui.search_lyrics

import androidx.lifecycle.MutableLiveData
import com.lyrcs.domain.common.ResultState
import com.lyrcs.domain.usecase.SearchTrackUseCase
import com.lyrcs.presentation.display.TrackDisplay
import com.lyrcs.presentation.mapper.TrackMapper
import com.lyrcs.presentation.ui.base.BaseViewModel
import javax.inject.Inject

class ViewModelSearchTracks @Inject constructor(
    private val searchTrackUseCase: SearchTrackUseCase,
    private val trackMapper: TrackMapper
) : BaseViewModel() {
    private val searchTracksLiveData = MutableLiveData<ResultState<List<TrackDisplay>>>()
    fun searchLyrics(trackName: String,
                     artistName: String) {
        disposable = searchTrackUseCase.searchTrack(trackName, artistName)
            .subscribe{ resultState ->
                if (resultState is ResultState.Success) {
                    val display = resultState.data.map {
                            track -> trackMapper.transform(track)
                    }
                    searchTracksLiveData.postValue(ResultState.Success(display))
                } else if(resultState is ResultState.Error) {
                    searchTracksLiveData.postValue(ResultState.Error(resultState.throwable, null))
                }
            }
    }
}