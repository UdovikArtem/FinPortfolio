package com.example.finportfolio.di

import com.example.finportfolio.data.local.LocalAssetDataSource
import com.example.finportfolio.data.local.LocalCurrencyDataSource
import com.example.finportfolio.data.local.LocalPortfolioDataSource
import com.example.finportfolio.data.repository.AssetRepositoryImpl
import com.example.finportfolio.data.repository.CurrencyRepositoryImpl
import com.example.finportfolio.data.repository.PortfolioRepositoryImpl
import com.example.finportfolio.data.repository.SettingStoreImpl
import com.example.finportfolio.domain.datasource.AssetDataSource
import com.example.finportfolio.domain.datasource.CurrencyDataSource
import com.example.finportfolio.domain.datasource.PortfolioDataSource
import com.example.finportfolio.domain.repository.AssetRepository
import com.example.finportfolio.domain.repository.CurrencyRepository
import com.example.finportfolio.domain.repository.PortfolioRepository
import com.example.finportfolio.domain.repository.SettingStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {
    @Binds
    @Singleton
    fun bindSettingStore(settingStoreImpl: SettingStoreImpl): SettingStore

    @Binds
    @Singleton
    fun bindAssetDataSource(localAssetDataSource: LocalAssetDataSource): AssetDataSource

    @Binds
    @Singleton
    fun bindAssetRepository(assetRepositoryImpl: AssetRepositoryImpl): AssetRepository

    @Binds
    @Singleton
    fun bindCurrencyDataSource(localCurrencyDataSource: LocalCurrencyDataSource): CurrencyDataSource

    @Binds
    @Singleton
    fun bindCurrencyRepository(currencyRepositoryImpl: CurrencyRepositoryImpl): CurrencyRepository

    @Binds
    @Singleton
    fun bindPortfolioRepository(
        portfolioRepositoryImpl: PortfolioRepositoryImpl
    ): PortfolioRepository

    @Binds
    @Singleton
    fun bindPortfolioDataSource(
        localPortfolioDataSource: LocalPortfolioDataSource
    ): PortfolioDataSource
}
