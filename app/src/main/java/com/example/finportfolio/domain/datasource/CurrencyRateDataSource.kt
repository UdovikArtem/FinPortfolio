package com.example.finportfolio.domain.datasource

import com.example.finportfolio.data.db.entity.CurrencyRateDbEntity
import com.example.finportfolio.domain.entity.CurrencyRate

interface CurrencyRateDataSource {
    suspend fun getCurrencyRate(code: String): CurrencyRate?
    suspend fun addOrUpdateCurrencyRate(currencyRate: CurrencyRateDbEntity)
}
