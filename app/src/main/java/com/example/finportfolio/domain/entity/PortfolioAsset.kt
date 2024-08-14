package com.example.finportfolio.domain.entity

import com.example.finportfolio.data.db.entity.PortfolioAssetDbEntity
import java.time.LocalDate

data class PortfolioAsset(
    val id: Int,
    val asset: Asset,
    val value: Int,
    val purchaseDate: LocalDate
) {
    fun toPortfolioAssetDbEntity(): PortfolioAssetDbEntity = PortfolioAssetDbEntity(
        id,
        asset.id,
        value,
        purchaseDate.toString()
    )
}
