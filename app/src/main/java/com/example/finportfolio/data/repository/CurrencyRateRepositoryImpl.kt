package com.example.finportfolio.data.repository

import androidx.datastore.core.IOException
import com.example.finportfolio.data.db.entity.toDomain
import com.example.finportfolio.data.remote.RemoteCurrencyRateDataSource
import com.example.finportfolio.data.remote.api.toDbEntity
import com.example.finportfolio.domain.datasource.CurrencyRateDataSource
import com.example.finportfolio.domain.entity.CurrencyRate
import com.example.finportfolio.domain.repository.CurrencyRateRepository
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class CurrencyRateRepositoryImpl @Inject constructor(
    private val localCurrencyRateDataSource: CurrencyRateDataSource,
    private val remoteCurrencyRateDataSource: RemoteCurrencyRateDataSource
) : CurrencyRateRepository {

    companion object {
        private const val DATE_START = 0
        private const val DATE_END = 10
    }

    override suspend fun getCurrencyRate(code: String): Result<CurrencyRate> {
        return withContext(Dispatchers.IO) {
            val currencyRate = localCurrencyRateDataSource.getCurrencyRate(code)
            try {
                if (currencyRate != null && LocalDate.parse(
                        currencyRate.data.subSequence(DATE_START, DATE_END)
                    ).isEqual(LocalDate.now())
                ) {
                    Result.success(currencyRate)
                } else {
                    Result.success(getRemoteCurrencyRate(code))
                }
            } catch (e: HttpException) {
                getExceptionResult(currencyRate, e)
            } catch (e: IOException) {
                getExceptionResult(currencyRate, e)
            }
        }
    }

    private suspend fun getRemoteCurrencyRate(code: String): CurrencyRate {
        return withContext(Dispatchers.IO) {
            val currencyRate = remoteCurrencyRateDataSource.getCurrencyRate(code).toDbEntity()
            localCurrencyRateDataSource.addOrUpdateCurrencyRate(currencyRate)
            currencyRate.toDomain()
        }
    }

    private fun getExceptionResult(currencyRate: CurrencyRate?, e: Exception):
        Result<CurrencyRate> {
        if (currencyRate != null) {
            return Result.success(currencyRate)
        }
        return Result.failure(e)
    }
}
