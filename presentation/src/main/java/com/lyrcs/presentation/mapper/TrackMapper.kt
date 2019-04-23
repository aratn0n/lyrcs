package com.lyrcs.presentation.mapper

import com.lyrcs.domain.entity.Track
import com.lyrcs.presentation.display.TrackDisplay
import javax.inject.Inject

class TrackMapper @Inject constructor() {

    fun transform(track: Track): TrackDisplay {
        return TrackDisplay(
            track.trackId,
            track.trackName,
            track.artistName
        )
    }
}