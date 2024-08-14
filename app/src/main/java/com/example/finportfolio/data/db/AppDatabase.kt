package com.example.finportfolio.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finportfolio.data.db.dao.AssetDao
import com.example.finportfolio.data.db.dao.PortfolioAssetDao
import com.example.finportfolio.data.db.entity.AssetDbEntity
import com.example.finportfolio.data.db.entity.PortfolioAssetDbEntity

@Database(
    version = 1,
    entities = [
        PortfolioAssetDbEntity::class,
        AssetDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getAssetDao(): AssetDao
    abstract fun gePortfolioAssetDao(): PortfolioAssetDao
}
