package com.lyrcs.data.entity

import com.google.gson.annotations.SerializedName
import com.lyrcs.domain.entity.Track

data class SearchLyricsResultEntity(@SerializedName ("track_list") val tracks: List<TrackEntity>) {
    fun toDomain(): List<Track>
        = tracks.map {
            it.toDomain()
        }
}