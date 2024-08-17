package com.example.finportfolio.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.finportfolio.domain.repository.SettingStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class SettingStoreImpl
@Inject constructor(
    @ApplicationContext private val context: Context
) : SettingStore {

    companion object {
        private const val PREFS_NAME = "portfolio_settings"
        private val KEY_DEFAULT_CURRENCY = stringPreferencesKey("default_currency")
    }

    private val Context.dataStore by preferencesDataStore(name = PREFS_NAME)

    override suspend fun setDefaultCurrency(currency: String) {
        withContext(Dispatchers.IO) {
            context.dataStore.edit { preferences ->
                preferences[KEY_DEFAULT_CURRENCY] = currency
            }
        }
    }

    override suspend fun getDefaultCurrency(): String {
        return withContext(Dispatchers.IO) {
            val preferences = context.dataStore.data.map { preferences ->
                preferences[KEY_DEFAULT_CURRENCY] ?: "USD"
            }
            preferences.first()
        }
    }
}
