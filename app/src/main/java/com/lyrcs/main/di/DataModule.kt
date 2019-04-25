package com.lyrcs.main.di

import com.lyrcs.data.repository.LyricsRepository
import com.lyrcs.data.api.LyricsApi
import com.lyrcs.domain.repository.LyricsRepositoryContract
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideLyricsRepository(lyricsApi: LyricsApi): LyricsRepositoryContract
        = LyricsRepository(lyricsApi)
}