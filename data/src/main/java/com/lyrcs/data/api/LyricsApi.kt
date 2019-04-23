package com.lyrcs.data.api

import com.lyrcs.data.entity.LyricsEntity
import com.lyrcs.data.entity.SearchLyricsResultEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LyricsApi {

    @GET("track.search")
    fun searchLyrics(@Query("q_track") trackName: String,
                     @Query("q_artist") artist: String)
            : Single<SearchLyricsResultEntity>

    @GET("track.lyrics.get")
    fun getLyrics(@Query ("track_id") trackId: String)
            : Single<LyricsEntity>
}