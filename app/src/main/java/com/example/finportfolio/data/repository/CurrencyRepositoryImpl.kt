package com.example.finportfolio.data.repository

import com.example.finportfolio.domain.datasource.CurrencyDataSource
import com.example.finportfolio.domain.entity.Currency
import com.example.finportfolio.domain.repository.CurrencyRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyDataSource: CurrencyDataSource
) : CurrencyRepository {
    override suspend fun getCurrencies(): List<Currency> {
        return withContext(Dispatchers.IO) {
            currencyDataSource.getCurrencies()
        }
    }
}
