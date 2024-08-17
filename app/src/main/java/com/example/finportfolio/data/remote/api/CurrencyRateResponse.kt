package com.example.finportfolio.data.remote.api

import com.example.finportfolio.data.db.entity.CurrencyRateDbEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyRateResponse(
    @SerialName("Cur_ID")
    val id: Int,
    @SerialName("Date")
    val date: String,
    @SerialName("Cur_Abbreviation")
    val abbreviation: String,
    @SerialName("Cur_Scale")
    val scale: Int,
    @SerialName("Cur_OfficialRate")
    val rate: Double
)

fun CurrencyRateResponse.toDbEntity(): CurrencyRateDbEntity = CurrencyRateDbEntity(
    id,
    date,
    abbreviation,
    scale,
    rate
)
