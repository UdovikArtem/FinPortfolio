package com.example.finportfolio.domain.entity

import java.time.LocalDate

data class PortfolioAsset(
    val id: Int,
    val asset: Asset,
    var value: Float,
    val purchaseDate: LocalDate
)
