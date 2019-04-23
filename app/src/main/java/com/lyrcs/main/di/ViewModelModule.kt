package com.lyrcs.main.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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

//    @Binds
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    internal abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}