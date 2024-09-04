package com.example.finportfolio.fragments.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finportfolio.domain.repository.SettingStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SettingViewModel
@Inject constructor(
    private val settingStore: SettingStore
) : ViewModel() {

    private val _currencyModel = MutableLiveData<String>()
    val currencyModel: LiveData<String> = _currencyModel

    init {
        viewModelScope.launch {
            _currencyModel.value = settingStore.getDefaultCurrency()
        }
    }

    fun setDefaultCurrency(currency: String) {
        viewModelScope.launch {
            settingStore.setDefaultCurrency(currency)
            _currencyModel.value = settingStore.getDefaultCurrency()
        }
    }
}
