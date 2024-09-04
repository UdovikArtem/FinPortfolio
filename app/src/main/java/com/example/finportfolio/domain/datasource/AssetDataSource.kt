package com.example.finportfolio.domain.datasource

import com.example.finportfolio.domain.entity.Asset

interface AssetDataSource {
    suspend fun getAssets(): List<Asset>
    suspend fun getAssetById(id: Int): Asset?
}
