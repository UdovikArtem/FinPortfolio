package com.example.finportfolio.data.repository

import com.example.finportfolio.domain.datasource.AssetDataSource
import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.repository.AssetRepository
import javax.inject.Inject

class AssetRepositoryImpl @Inject constructor(
    private val assetDataSource: AssetDataSource
) : AssetRepository {
    override fun getAssets(): List<Asset> = assetDataSource.getAssets()
    override fun getAssetById(id: Int): Asset? = assetDataSource.getAssetById(id)
}
