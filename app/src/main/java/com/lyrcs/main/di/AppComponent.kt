package com.lyrcs.main.di

import com.lyrcs.main.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    AppModule::class,
    DataModule::class,
    NetworkModule::class,
    ActivityModule::class,
    FragmentModule::class
])
interface AppComponent: AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}