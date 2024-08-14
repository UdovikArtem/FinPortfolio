package com.example.finportfolio.data.db

import android.content.Context
import androidx.room.Room
import com.example.finportfolio.data.db.dao.AssetDao
import com.example.finportfolio.data.db.dao.PortfolioAssetDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideAssetDao(appDatabase: AppDatabase): AssetDao {
        return appDatabase.getAssetDao()
    }

    @Provides
    fun providePortfolioAssetDao(appDatabase: AppDatabase): PortfolioAssetDao {
        return appDatabase.gePortfolioAssetDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "fin_portfolio.db"
        ).createFromAsset("portfolio.db")
            .build()
    }
}
