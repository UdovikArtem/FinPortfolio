package com.example.finportfolio.data.local

import com.example.finportfolio.data.db.dao.CurrencyRateDao
import com.example.finportfolio.data.db.entity.CurrencyRateDbEntity
import com.example.finportfolio.data.db.entity.toDomain
import com.example.finportfolio.domain.datasource.CurrencyRateDataSource
import com.example.finportfolio.domain.entity.CurrencyRate
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalCurrencyRateDataSource @Inject constructor(
    private val currencyRateDao: CurrencyRateDao
) : CurrencyRateDataSource {
    override suspend fun getCurrencyRate(code: String): CurrencyRate? =
        withContext(Dispatchers.IO) {
            currencyRateDao.getCurrencyRate(code)?.toDomain()
        }

    override suspend fun addOrUpdateCurrencyRate(currencyRate: CurrencyRateDbEntity) {
        currencyRateDao.addOrUpdateCurrencyRate(currencyRate)
    }
}
