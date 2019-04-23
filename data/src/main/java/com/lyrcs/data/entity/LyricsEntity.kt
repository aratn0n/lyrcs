package com.lyrcs.data.entity

import com.lyrcs.domain.entity.Lyrics

class LyricsEntity {

    fun toDomain() = Lyrics (
        "trackName",
        "articst",
        "lyrics"
    )
}