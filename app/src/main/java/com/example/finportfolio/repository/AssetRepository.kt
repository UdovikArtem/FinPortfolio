package com.example.finportfolio.repository

import com.example.finportfolio.entity.Asset

object AssetRepository {
    private val assets: HashMap<Int, Asset> = HashMap(listOf(
        Asset(
            id = 1,
            name = "BYN"
        ),
        Asset(
            id = 2,
            name = "RUB"
        ),
        Asset(
            id = 3,
            name = "USD"
        ),
        Asset(
            id = 4,
            name = "EUR"
        ),
        Asset(
            id = 5,
            name = "CNY"
        )
    ).associateBy { it.id })

    fun getAssets(): List<Asset> = assets.values.toList()
    fun getAssetById(id: Int): Asset? = assets[id]
}