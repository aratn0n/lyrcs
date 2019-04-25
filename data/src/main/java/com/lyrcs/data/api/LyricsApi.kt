package com.lyrcs.data.api

import com.lyrcs.data.entity.LyricsEntity
import com.lyrcs.data.entity.LyricsItemEntity
import com.lyrcs.data.entity.SearchLyricsResultEntity
import com.lyrcs.data.entity.base.BodyEntity
import com.lyrcs.data.entity.base.ResponseEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LyricsApi {

    @GET("track.search")
    fun searchLyrics(@Query("q_track") trackName: String,
                     @Query("q_artist") artist: String)
            : Single<ResponseEntity<SearchLyricsResultEntity>>

    @GET("track.lyrics.get")
    fun getLyrics(@Query ("track_id") trackId: String)
            : Single<ResponseEntity<LyricsItemEntity>>
}