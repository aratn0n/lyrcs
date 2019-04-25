package com.lyrcs.main.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lyrcs.presentation.ui.displaylyrics.ViewModelDisplayLyrics
import com.lyrcs.presentation.ui.searchlyrics.ViewModelSearchTracks
import com.lyrcs.presentation.ui.searchresult.ViewModelSearchResult
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Dr.jacky on 9/10/2018.
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelSearchTracks::class)
    internal abstract fun bindViewModelSearchTracks(viewModel: ViewModelSearchTracks): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelSearchResult::class)
    internal abstract fun bindViewModelSearchResult(viewModel: ViewModelSearchResult): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelDisplayLyrics::class)
    internal abstract fun bindViewModelDisplayLyrics(viewModel: ViewModelDisplayLyrics): ViewModel
}