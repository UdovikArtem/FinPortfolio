package com.example.finportfolio.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.finportfolio.domain.repository.SettingStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SettingStoreImpl @Inject
constructor(@ApplicationContext context: Context) : SettingStore {
    companion object {
        private const val PREFS_NAME = "portfolio_settings"
        private const val KEY_DEFAULT_CURRENCY = "default_currency"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override suspend fun setDefaultCurrency(currency: String) {
        sharedPreferences.edit().putString(KEY_DEFAULT_CURRENCY, currency).apply()
    }

    override suspend fun getDefaultCurrency(): String {
        return sharedPreferences.getString(KEY_DEFAULT_CURRENCY, "USD") ?: "USD"
    }
}
