package com.example.finportfolio.domain.interactors

import com.example.finportfolio.domain.entity.Currency
import com.example.finportfolio.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyInteractor @Inject constructor(
    private val repository: CurrencyRepository
) {
    fun getCurrencies(): List<Currency> = repository.getCurrencies()
}
