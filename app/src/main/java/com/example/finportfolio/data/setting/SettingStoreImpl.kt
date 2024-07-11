package com.example.finportfolio.data.setting

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

    override fun setDefaultCurrency(currency: String) {
        sharedPreferences.edit().putString(KEY_DEFAULT_CURRENCY, currency).apply()
    }

    override fun getDefaultCurrency(): String {
        return sharedPreferences.getString(KEY_DEFAULT_CURRENCY, "USD") ?: "USD"
    }
}
