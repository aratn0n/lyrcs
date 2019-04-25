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
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        val urlBuilder = HttpUrl.parse("https://api.musixmatch.com/ws/1.1/")!!.newBuilder()
//        urlBuilder.addQueryParameter("apikey", "1940f4bf677988dedbd9fa57d4f3a314")

        return Retrofit.Builder()
            .baseUrl("https://api.musixmatch.com/ws/1.1/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
            return OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request()
                    val url = request.url().newBuilder()
                        .addQueryParameter("apikey", "1940f4bf677988dedbd9fa57d4f3a314")
                        .build()
                    val newRequest = chain.request()
                        .newBuilder()
                        .url(url)
                        .build()
                    chain.proceed(newRequest)
        }
    }

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