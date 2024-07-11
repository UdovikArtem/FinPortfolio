package com.example.finportfolio.fragments.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finportfolio.domain.repository.SettingStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel
@Inject constructor(
    private val settingStore: SettingStore
) : ViewModel() {

    private val _currencyModel = MutableLiveData<String>()
    val currencyModel: LiveData<String> = _currencyModel

    init {
        _currencyModel.value = settingStore.getDefaultCurrency()
    }

    fun setDefaultCurrency(currency: String) {
        settingStore.setDefaultCurrency(currency)
        _currencyModel.value = settingStore.getDefaultCurrency()
    }
}
