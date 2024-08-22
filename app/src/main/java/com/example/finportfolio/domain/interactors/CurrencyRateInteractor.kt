package com.example.finportfolio.domain.interactors

import com.example.finportfolio.domain.entity.CurrencyRate
import com.example.finportfolio.domain.repository.CurrencyRateRepository
import com.example.finportfolio.roundToTwoDecimalPlaces
import java.time.LocalDate
import javax.inject.Inject

class CurrencyRateInteractor @Inject constructor(
    private val repository: CurrencyRateRepository
) {
    suspend fun getCurrencyRate(code: String): CurrencyRate {
        repository.getCurrencyRate(code).onSuccess {
            return it
        }
        return (CurrencyRate(0, LocalDate.now().toString(), "BYN", 1, 1.0))
    }

    fun convertCurrencyFromByn(currencyRate: CurrencyRate, value: Float): Float =
        (value * (currencyRate.scale / currencyRate.rate)).toFloat().roundToTwoDecimalPlaces()

    fun convertCurrencyToByn(currencyRate: CurrencyRate, value: Float): Float =
        (value * (currencyRate.rate / currencyRate.scale)).toFloat().roundToTwoDecimalPlaces()
}
