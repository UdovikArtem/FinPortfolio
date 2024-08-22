package com.example.finportfolio.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.finportfolio.domain.entity.PortfolioAsset

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
    val value: Float,
    @ColumnInfo(name = "purchase_date")
    val purchaseDate: String
) {
    companion object {
        fun fromDomain(domain: PortfolioAsset): PortfolioAssetDbEntity {
            return PortfolioAssetDbEntity(
                id = domain.id,
                assetId = domain.asset.id,
                value = domain.value,
                purchaseDate = domain.purchaseDate.toString()
            )
        }
    }
}
