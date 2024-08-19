package com.example.finportfolio.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.finportfolio.domain.entity.CurrencyRate

@Entity(tableName = "currency_rate")
data class CurrencyRateDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "abbreviation")
    val abbreviation: String,
    @ColumnInfo(name = "scale")
    val scale: Int,
    @ColumnInfo(name = "rate")
    val rate: Double
)

fun CurrencyRateDbEntity.toDomain(): CurrencyRate = CurrencyRate(
    id,
    date,
    abbreviation,
    scale,
    rate
)
