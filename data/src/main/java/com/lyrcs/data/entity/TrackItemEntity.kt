package com.lyrcs.data.entity

import com.google.gson.annotations.SerializedName
import com.lyrcs.domain.entity.Track

data class TrackItemEntity(@SerializedName ("track") val track: TrackEntity) {

    fun toDomain() = Track (
        track.trackId,
        track.trackName,
        track.artistName
    )
}