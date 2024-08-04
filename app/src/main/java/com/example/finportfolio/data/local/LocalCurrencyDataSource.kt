package com.example.finportfolio.data.local

import com.example.finportfolio.domain.datasource.CurrencyDataSource
import com.example.finportfolio.domain.entity.Currency
import javax.inject.Inject

class LocalCurrencyDataSource @Inject constructor() : CurrencyDataSource {
    override suspend fun getCurrencies(): List<Currency> = Currency.entries.toTypedArray().toList()
}
