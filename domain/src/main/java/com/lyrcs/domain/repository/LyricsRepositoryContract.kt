package com.lyrcs.domain.repository

import com.lyrcs.domain.entity.Lyrics
import com.lyrcs.domain.entity.Track
import com.lyrcs.domain.common.ResultState
import io.reactivex.Single

interface LyricsRepositoryContract: BaseRepository {

    fun searchTracks(trackName: String,
                     artistName: String)
        : Single<ResultState<List<Track>>>

    fun getLyrics(trackId: String)
        : Single<ResultState<Lyrics>>

}