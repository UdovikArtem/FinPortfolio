package com.example.finportfolio.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.entity.Cash
import com.example.finportfolio.domain.entity.Currency
import com.example.finportfolio.domain.entity.Stock

@Entity(tableName = "assets")
data class AssetDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "currency") val currency: String? = null,
    @ColumnInfo(name = "ticker") val ticker: String? = null
) {
    fun toAsset(): Asset {
        val asset: Asset = when (this.type) {
            "Cash" -> Cash(id, name, Currency.valueOf(currency!!))
            "Stock" -> Stock(id, name, ticker!!)
            else -> Asset(id, name)
        }

        return asset
    }
}
