package com.example.finportfolio.data.setting

interface SettingStore {
    fun setDefaultCurrency(currency: String)
    fun getDefaultCurrency(): String
}
