package com.lyrcs.domain.usecase

import com.lyrcs.domain.entity.Lyrics
import com.lyrcs.domain.repository.LyricsRepositoryContract
import io.reactivex.Single
import javax.inject.Inject

class GetLyricsUseCase @Inject constructor(private val lyricsRepositoryContract: LyricsRepositoryContract) {

    fun getLyrics(trackId: String): Single<Lyrics> {
        return lyricsRepositoryContract.getLyrics(trackId)
    }
}