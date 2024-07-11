package com.example.finportfolio.domain.repository

interface SettingStore {
    fun setDefaultCurrency(currency: String)
    fun getDefaultCurrency(): String
}
