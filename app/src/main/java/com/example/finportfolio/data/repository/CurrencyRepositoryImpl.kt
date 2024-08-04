package com.example.finportfolio.data.repository

import com.example.finportfolio.domain.datasource.CurrencyDataSource
import com.example.finportfolio.domain.entity.Currency
import com.example.finportfolio.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyDataSource: CurrencyDataSource
) : CurrencyRepository {
    override suspend fun getCurrencies(): List<Currency> = currencyDataSource.getCurrencies()
}
