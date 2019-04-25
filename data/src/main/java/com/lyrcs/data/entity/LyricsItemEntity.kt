package com.lyrcs.data.entity

import com.google.gson.annotations.SerializedName
import com.lyrcs.domain.entity.Lyrics

data class LyricsItemEntity(@SerializedName("lyrics") val lyricsEntity: LyricsEntity) {
    fun toDomain() = Lyrics (
        lyricsEntity.lyrics
    )
}