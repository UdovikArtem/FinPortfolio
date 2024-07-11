package com.example.finportfolio.domain.repository

import com.example.finportfolio.domain.entity.Asset

interface AssetRepository {
    fun getAssets(): List<Asset>
    fun getAssetById(id: Int): Asset?
}
