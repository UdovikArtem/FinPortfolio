package com.example.finportfolio.fragments.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finportfolio.data.setting.SettingStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel
@Inject constructor(
    private val settingStore: SettingStore
) : ViewModel() {

    private val _model = MutableLiveData<String>()
    val model: LiveData<String> = _model

    init {
        _model.value = settingStore.getDefaultCurrency()
    }

    fun setDefaultCurrency(currency: String) {
        settingStore.setDefaultCurrency(currency)
        _model.value = settingStore.getDefaultCurrency()
    }

    fun getDefaultCurrency(): String {
        return _model.value ?: "USD"
    }
}
