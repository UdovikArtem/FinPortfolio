package com.example.finportfolio.domain.repository

import com.example.finportfolio.domain.entity.Currency

interface CurrencyRepository {
    suspend fun getCurrencies(): List<Currency>
}
