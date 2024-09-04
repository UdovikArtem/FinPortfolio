package com.example.finportfolio.data.remote

import com.example.finportfolio.data.remote.api.CurrencyRateApiService
import com.example.finportfolio.data.remote.api.CurrencyRateResponse
import javax.inject.Inject

class RemoteCurrencyRateDataSource @Inject constructor(
    private val currencyRateApiService: CurrencyRateApiService
) {
    suspend fun getCurrencyRate(code: String): CurrencyRateResponse =
        currencyRateApiService.getCurrencyRate(code)
}
