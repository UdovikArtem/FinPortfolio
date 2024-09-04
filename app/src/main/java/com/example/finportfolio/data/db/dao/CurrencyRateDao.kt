package com.example.finportfolio.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.finportfolio.data.db.entity.CurrencyRateDbEntity

@Dao
interface CurrencyRateDao {
    @Upsert
    fun addOrUpdateCurrencyRate(currencyRate: CurrencyRateDbEntity)

    @Query(
        "SELECT * FROM currency_rate WHERE currency_rate.abbreviation = :abbreviation" +
            " ORDER BY id DESC LIMIT 1"
    )
    fun getCurrencyRate(abbreviation: String): CurrencyRateDbEntity?
}
