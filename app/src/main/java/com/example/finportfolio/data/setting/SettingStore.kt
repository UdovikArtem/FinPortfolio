package com.example.finportfolio.data.setting

import android.content.Context
import android.content.SharedPreferences

class SettingStore(context: Context) {
    companion object {
        private const val PREFS_NAME = "portfolio_settings"
        private const val KEY_DEFAULT_CURRENCY = "default_currency"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setDefaultCurrency(currency: String) {
        sharedPreferences.edit().putString(KEY_DEFAULT_CURRENCY, currency).apply()
    }

    fun getDefaultCurrency(): String {
        return sharedPreferences.getString(KEY_DEFAULT_CURRENCY, "USD") ?: "USD"
    }
}
