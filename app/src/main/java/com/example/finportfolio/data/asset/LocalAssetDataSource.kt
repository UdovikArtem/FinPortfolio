package com.example.finportfolio.data.asset

import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.entity.Cash
import com.example.finportfolio.domain.entity.Stock
import javax.inject.Inject

class LocalAssetDataSource @Inject constructor() : AssetDataSource {
    private val assets: Map<Int, Asset> = HashMap(
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
    override fun getAssets(): List<Asset> = assets.values.toList()

    override fun getAssetById(id: Int): Asset? = assets[id]
}
