package com.lyrcs.presentation.mapper

import com.lyrcs.domain.entity.Lyrics
import com.lyrcs.presentation.display.LyricsDisplay
import javax.inject.Inject

class LyricsMapper @Inject constructor() {
    fun transform(trackName: String,
                  artistName: String,
                  lyrics: Lyrics): LyricsDisplay {
        return LyricsDisplay(
            trackName,
            artistName,
            lyrics.lyrics
        )
    }
}