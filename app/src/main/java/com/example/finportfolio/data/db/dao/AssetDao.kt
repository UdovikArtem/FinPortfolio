package com.example.finportfolio.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.finportfolio.data.db.entity.AssetDbEntity

@Dao
interface AssetDao {
    @Query("SELECT * FROM assets")
    fun getAssets(): List<AssetDbEntity>

    @Query("SELECT * FROM assets WHERE assets.id == :id")
    fun getAssetById(id: Int): AssetDbEntity?
}
