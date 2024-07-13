package com.example.finportfolio.data.asset

import com.example.finportfolio.domain.entity.Asset

interface AssetDataSource {
    fun getAssets(): List<Asset>
    fun getAssetById(id: Int): Asset?
}
