package com.example.finportfolio.domain.repository

import com.example.finportfolio.domain.entity.Currency

interface CurrencyRepository {
    fun getCurrencies(): List<Currency>
}
