package com.example.finportfolio.domain.datasource

import com.example.finportfolio.domain.entity.Currency

interface CurrencyDataSource {
    fun getCurrencies(): List<Currency>
}
