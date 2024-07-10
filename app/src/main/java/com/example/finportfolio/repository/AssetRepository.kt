package com.example.finportfolio.repository

import com.example.finportfolio.entity.Asset
import com.example.finportfolio.entity.Cash
import com.example.finportfolio.entity.Stock

object AssetRepository {
    private val assets: HashMap<Int, Asset> = HashMap(
        listOf(
            Cash(
                id = 1,
                name = "Belarusian Ruble",
                currency = "BYN"
            ),
            Cash(
                id = 2,
                name = "Russian Ruble",
                currency = "RUB"
            ),
            Cash(
                id = 3,
                name = "US Dollar",
                currency = "USD"
            ),
            Cash(
                id = 4,
                name = "Euro",
                currency = "EUR"
            ),
            Cash(
                id = 5,
                name = "Chinese Yuan",
                currency = "CNY"
            ),
            Stock(
                id = 6,
                name = "Apple stock",
                ticker = "AAPL"
            ),
            Stock(
                id = 7,
                name = "NVIDIA Corporation Stock",
                ticker = "NVDA"
            ),
            Stock(
                id = 8,
                name = "Advanced Micro Devices, Inc. Stock",
                ticker = "AMD"
            )
        ).associateBy { it.id }
    )

    fun getAssets(): List<Asset> = assets.values.toList()
    fun getAssetById(id: Int): Asset? = assets[id]
}
