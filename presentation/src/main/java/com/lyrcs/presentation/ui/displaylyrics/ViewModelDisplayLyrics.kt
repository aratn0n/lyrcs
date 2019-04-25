package com.lyrcs.presentation.ui.displaylyrics

import androidx.lifecycle.MutableLiveData
import com.lyrcs.domain.common.ResultState
import com.lyrcs.domain.usecase.SearchTrackUseCase
import com.lyrcs.presentation.display.LyricsDisplay
import com.lyrcs.presentation.display.SearchResultDisplay
import com.lyrcs.presentation.mapper.TrackMapper
import com.lyrcs.presentation.ui.base.BaseViewModel
import com.lyrcs.presentation.ui.base.SingleLiveEvent
import javax.inject.Inject

class ViewModelDisplayLyrics @Inject constructor(
) : BaseViewModel() {
    private val displayLyricsLiveData = SingleLiveEvent<ResultState<LyricsDisplay>>()

    fun getDisplayLyricsLiveData() = displayLyricsLiveData

    fun start(lyricsDisplay: LyricsDisplay) {
        displayLyricsLiveData.postValue(ResultState.Success(lyricsDisplay))
    }
}