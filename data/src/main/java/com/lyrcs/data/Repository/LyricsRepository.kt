package com.lyrcs.data.Repository

import com.lyrcs.data.api.LyricsApi
import com.lyrcs.data.common.extension.applyIoScheduler
import com.lyrcs.domain.entity.Lyrics
import com.lyrcs.domain.entity.Track
import com.lyrcs.domain.common.ResultState
import com.lyrcs.domain.repository.LyricsRepositoryContract
import io.reactivex.Single

class LyricsRepository(private val lyricsApi: LyricsApi): LyricsRepositoryContract {
    override fun searchTracks(trackName: String,
                              artistName: String)
            : Single<ResultState<List<Track>>> {
        return lyricsApi.searchLyrics(trackName, artistName)
            .applyIoScheduler()
            .map { searchResult -> ResultState.Success(searchResult.toDomain()) as ResultState<List<Track>> }
            .onErrorReturn { error -> ResultState.Error(error, null) }
    }

    override fun getLyrics(trackId: String): Single<ResultState<Lyrics>> {
        return lyricsApi.getLyrics(trackId)
            .applyIoScheduler()
            .map { entity -> ResultState.Success(entity.toDomain()) as ResultState<Lyrics> }
            .onErrorReturn { error -> ResultState.Error(error, null) }
    }
}