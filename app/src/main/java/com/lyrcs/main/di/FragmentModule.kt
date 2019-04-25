package com.lyrcs.main.di

import com.lyrcs.presentation.ui.displaylyrics.FragmentDisplayLyrics
import com.lyrcs.presentation.ui.searchlyrics.FragmentSearchLyrics
import com.lyrcs.presentation.ui.searchresult.FragmentSearchResult
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun getFragmentSearchLyrics(): FragmentSearchLyrics

    @ContributesAndroidInjector
    abstract fun getFragmentSearchResult(): FragmentSearchResult

    @ContributesAndroidInjector
    abstract fun getiFragmentDisplayLyrics(): FragmentDisplayLyrics
}