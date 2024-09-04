package com.example.finportfolio.domain.entity

data class CurrencyRate(
    val id: Int,
    val data: String,
    val abbreviation: String,
    val scale: Int,
    val rate: Double
)
