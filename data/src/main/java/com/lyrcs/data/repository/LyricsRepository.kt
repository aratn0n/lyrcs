package com.lyrcs.data.repository

import com.lyrcs.data.api.LyricsApi
import com.lyrcs.data.common.extension.applyIoScheduler
import com.lyrcs.domain.entity.Lyrics
import com.lyrcs.domain.entity.Track
import com.lyrcs.domain.repository.LyricsRepositoryContract
import io.reactivex.Single

class LyricsRepository(private val lyricsApi: LyricsApi): LyricsRepositoryContract {
    override fun searchTracks(trackName: String, artistName: String)
            : Single<List<Track>> {
        return lyricsApi.searchLyrics(trackName, artistName)
            .applyIoScheduler()
            .map { searchResult -> searchResult.getBody().toDomain() }
    }

    override fun getLyrics(trackId: String): Single<Lyrics> {
        return lyricsApi.getLyrics(trackId)
            .applyIoScheduler()
            .map { entity -> entity.getBody().toDomain() }
    }
}