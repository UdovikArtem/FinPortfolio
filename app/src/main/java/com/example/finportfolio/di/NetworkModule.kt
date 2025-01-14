package com.example.finportfolio.di

import com.example.finportfolio.data.remote.api.CurrencyRateApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    companion object {
        private const val BASE_URL = "https://api.nbrb.by"
        private const val CONNECTION_TIMEOUT_SECONDS = 30L
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideCurrencyRateApiService(retrofit: Retrofit): CurrencyRateApiService {
        return retrofit.create(CurrencyRateApiService::class.java)
    }
}
