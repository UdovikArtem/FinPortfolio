package com.example.finportfolio.di

import android.content.Context
import com.example.finportfolio.data.setting.SettingStore
import com.example.finportfolio.data.setting.SettingStoreImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideSettingStore(@ApplicationContext context: Context): SettingStore {
        return SettingStoreImpl(context)
    }
}
