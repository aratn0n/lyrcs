package com.lyrcs.main.di

import com.lyrcs.presentation.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module()
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun getMainActivity(): MainActivity
}