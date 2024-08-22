package com.example.finportfolio.data.db

import androidx.room.ColumnInfo
import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.entity.Cash
import com.example.finportfolio.domain.entity.Currency
import com.example.finportfolio.domain.entity.PortfolioAsset
import com.example.finportfolio.domain.entity.Stock
import java.time.LocalDate

data class PortfolioAssetTuple(
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "asset_id") val assetId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "currency") val currency: String? = null,
    @ColumnInfo(name = "ticker") val ticker: String? = null,
    @ColumnInfo(name = "value") val value: Float,
    @ColumnInfo(name = "purchase_date") val purchaseDate: String
) {
    fun toPortfolioAsset(): PortfolioAsset {
        val asset: Asset = when (type) {
            "Cash" -> Cash(id, name, Currency.valueOf(currency!!))
            "Stock" -> Stock(id, name, ticker!!)
            else -> Asset(id, name)
        }

        return PortfolioAsset(
            id,
            asset,
            value,
            LocalDate.parse(purchaseDate)
        )
    }
}
