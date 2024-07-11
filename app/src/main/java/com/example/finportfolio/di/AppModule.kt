package com.example.finportfolio.di

import com.example.finportfolio.data.asset.AssetRepositoryImpl
import com.example.finportfolio.data.setting.SettingStoreImpl
import com.example.finportfolio.domain.repository.AssetRepository
import com.example.finportfolio.domain.repository.SettingStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {
    @Binds
    fun bindSettingStore(settingStoreImpl: SettingStoreImpl): SettingStore

    @Binds
    fun bindAssetRepository(assetRepositoryImpl: AssetRepositoryImpl): AssetRepository
}
