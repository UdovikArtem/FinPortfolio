package com.example.finportfolio.domain.repository

import com.example.finportfolio.domain.entity.Asset

interface AssetRepository {
    suspend fun getAssets(): List<Asset>
    suspend fun getAssetById(id: Int): Asset?
}
