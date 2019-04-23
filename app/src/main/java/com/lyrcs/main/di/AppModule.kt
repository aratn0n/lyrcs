package com.lyrcs.main.di

import android.content.Context
import android.content.res.Resources
import com.lyrcs.main.App
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    abstract fun provideApplicationContext(app: App): Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideAppResource(context: Context): Resources
            = context.resources
    }
}