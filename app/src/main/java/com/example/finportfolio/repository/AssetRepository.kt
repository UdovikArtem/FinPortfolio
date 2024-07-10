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
                price = 1.0,
                currency = "BYN"
            ),
            Cash(
                id = 2,
                name = "Russian Ruble",
                price = 0.036,
                currency = "RUB"
            ),
            Cash(
                id = 3,
                name = "US Dollar",
                price = 3.20,
                currency = "USD"
            ),
            Cash(
                id = 4,
                name = "Euro",
                price = 3.48,
                currency = "EUR"
            ),
            Cash(
                id = 5,
                name = "Chinese Yuan",
                price = 0.439,
                currency = "CNY"
            ),
            Stock(
                id = 6,
                name = "Apple stock",
                price = 731.8,
                ticker = "AAPL"
            ),
            Stock(
                id = 7,
                name = "NVIDIA Corporation Stock",
                price = 420.5,
                ticker = "NVDA"
            ),
            Stock(
                id = 8,
                name = "Advanced Micro Devices, Inc. Stock",
                price = 566.4,
                ticker = "AMD"
            )
        ).associateBy { it.id }
    )

    fun getAssets(): List<Asset> = assets.values.toList()
    fun getAssetById(id: Int): Asset? = assets[id]
}
