package com.lyrcs.main.di

import com.lyrcs.data.api.LyricsApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient)
        = Retrofit.Builder()
            .baseUrl("https://api.musixmatch.com/ws/1.1")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()

    @Provides
    fun providesOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder,
                             httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return okHttpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun providesAlbumApi(retrofit: Retrofit): LyricsApi = retrofit.create(LyricsApi::class.java)
}