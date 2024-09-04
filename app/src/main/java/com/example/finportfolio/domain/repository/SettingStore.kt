package com.example.finportfolio.domain.repository

interface SettingStore {
    suspend fun setDefaultCurrency(currency: String)
    suspend fun getDefaultCurrency(): String
}
