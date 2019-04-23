package com.lyrcs.data.entity

import com.google.gson.annotations.SerializedName
import com.lyrcs.domain.entity.Track

data class TrackEntity(@SerializedName ("track_id") val trackId: String,
                       @SerializedName ("track_name") val trackName: String,
                       @SerializedName ("artist_name") val artistName: String) {

    fun toDomain() = Track (
        trackId,
        trackName,
        artistName
    )
}