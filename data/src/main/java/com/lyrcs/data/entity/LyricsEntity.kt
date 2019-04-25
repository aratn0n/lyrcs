package com.lyrcs.data.entity

import com.google.gson.annotations.SerializedName
import com.lyrcs.domain.entity.Lyrics

data class LyricsEntity(@SerializedName("lyrics_body") val lyrics: String) {
}