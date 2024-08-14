package com.example.finportfolio.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "portfolio_assets",
    foreignKeys = [
        ForeignKey(
            entity = AssetDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["asset_id"]
        )
    ]
)
data class PortfolioAssetDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "asset_id")
    val assetId: Int,
    @ColumnInfo(name = "value")
    val value: Int,
    @ColumnInfo(name = "purchase_date")
    val purchaseDate: String
)
