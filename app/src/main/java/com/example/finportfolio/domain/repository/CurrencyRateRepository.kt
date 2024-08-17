package com.example.finportfolio.domain.repository

import com.example.finportfolio.domain.entity.CurrencyRate

interface CurrencyRateRepository {
    suspend fun getCurrencyRate(code: String): Result<CurrencyRate>
}
