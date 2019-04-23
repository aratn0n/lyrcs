package com.lyrcs.domain.usecase

import com.lyrcs.domain.entity.Track
import com.lyrcs.domain.common.ResultState
import com.lyrcs.domain.repository.LyricsRepositoryContract
import io.reactivex.Single
import javax.inject.Inject

class SearchTrackUseCase @Inject constructor(private val lyricsRepositoryContract: LyricsRepositoryContract) {

    fun searchTrack(trackName: String,
                  artistName: String): Single<ResultState<List<Track>>> {
        return lyricsRepositoryContract.searchTracks(trackName, artistName)
    }
}