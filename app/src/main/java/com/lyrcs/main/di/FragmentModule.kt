package com.lyrcs.main.di

import com.lyrcs.presentation.ui.display_lyrics.FragmentDisplayLyrics
import com.lyrcs.presentation.ui.search_lyrics.FragmentSearchLyrics
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun getFragmentSearchLyrics(): FragmentSearchLyrics

    @ContributesAndroidInjector
    abstract fun getiFragmentDisplayLyrics(): FragmentDisplayLyrics
}