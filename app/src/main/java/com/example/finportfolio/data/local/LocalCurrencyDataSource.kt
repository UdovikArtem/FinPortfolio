package com.example.finportfolio.data.local

import com.example.finportfolio.domain.datasource.CurrencyDataSource
import com.example.finportfolio.domain.entity.Currency
import javax.inject.Inject

class LocalCurrencyDataSource @Inject constructor() : CurrencyDataSource {
    private val defaultCurrencies = Currency.entries.toTypedArray()

    override fun getCurrencies(): List<Currency> = defaultCurrencies.toList()
}
