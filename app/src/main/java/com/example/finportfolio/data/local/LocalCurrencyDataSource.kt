package com.example.finportfolio.data.local

import com.example.finportfolio.domain.datasource.CurrencyDataSource
import com.example.finportfolio.domain.entity.Currency
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalCurrencyDataSource @Inject constructor() : CurrencyDataSource {
    override suspend fun getCurrencies(): List<Currency> {
        return withContext(Dispatchers.IO) {
            Currency.entries.toTypedArray().toList()
        }
    }
}
