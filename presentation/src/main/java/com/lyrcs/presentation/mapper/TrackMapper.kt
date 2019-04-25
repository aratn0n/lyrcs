package com.lyrcs.presentation.mapper

import com.lyrcs.domain.entity.Track
import com.lyrcs.presentation.display.SearchResultDisplay
import javax.inject.Inject

class TrackMapper @Inject constructor() {

    fun transform(track: Track): SearchResultDisplay {
        return SearchResultDisplay(
            track.trackId,
            track.trackName,
            track.artistName
        )
    }
}