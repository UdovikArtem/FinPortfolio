package com.example.finportfolio.domain.entity

import java.time.LocalDate

data class PortfolioAsset(
    val id: Int,
    val asset: Asset,
    val value: Int,
    val purchaseDate: LocalDate
)
