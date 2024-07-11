package com.example.finportfolio.data.setting

import android.content.Context
import android.content.SharedPreferences

class SettingStoreImpl(context: Context) : SettingStore {
    companion object {
        private const val PREFS_NAME = "portfolio_settings"
        private const val KEY_DEFAULT_CURRENCY = "default_currency"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun setDefaultCurrency(currency: String) {
        sharedPreferences.edit().putString(KEY_DEFAULT_CURRENCY, currency).apply()
    }

    override fun getDefaultCurrency(): String {
        return sharedPreferences.getString(KEY_DEFAULT_CURRENCY, "USD") ?: "USD"
    }
}
