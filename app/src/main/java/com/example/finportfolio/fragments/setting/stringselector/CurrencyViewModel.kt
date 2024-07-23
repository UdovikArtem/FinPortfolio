package com.example.finportfolio.fragments.setting.stringselector

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finportfolio.domain.entity.Currency
import com.example.finportfolio.domain.interactors.CurrencyInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val currencyInteractor: CurrencyInteractor
) : ViewModel() {
    private val _currencies = MutableLiveData<List<Currency>>()
    val currencies: LiveData<List<Currency>> = _currencies

    init {
        _currencies.value = currencyInteractor.getCurrencies()
    }
}
