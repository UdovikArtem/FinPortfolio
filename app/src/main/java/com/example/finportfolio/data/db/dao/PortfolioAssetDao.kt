package com.example.finportfolio.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.finportfolio.data.db.PortfolioAssetTuple
import com.example.finportfolio.data.db.entity.PortfolioAssetDbEntity

@Dao
interface PortfolioAssetDao {
    @Insert(entity = PortfolioAssetDbEntity::class)
    fun addPortfolioAsset(asset: PortfolioAssetDbEntity)

    @Delete(entity = PortfolioAssetDbEntity::class)
    fun deletePortfolioAsset(asset: PortfolioAssetDbEntity)

    @Delete
    fun deleteListOfPortfolioAsset(assets: List<PortfolioAssetDbEntity>)

    @Query(
        "SELECT portfolio_assets.id, asset_id, name, type, currency, ticker, value, " +
            "purchase_date FROM portfolio_assets\n" +
            "INNER JOIN assets ON portfolio_assets.asset_id = assets.id\n;"
    )
    fun getPortfolioAssets(): List<PortfolioAssetTuple>
}
