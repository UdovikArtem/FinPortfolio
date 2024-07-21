package com.example.finportfolio.domain.datasource

import com.example.finportfolio.domain.entity.Asset

interface AssetDataSource {
    fun getAssets(): List<Asset>
    fun getAssetById(id: Int): Asset?
}
