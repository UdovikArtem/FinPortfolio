package com.example.finportfolio.data.repository

import com.example.finportfolio.domain.datasource.AssetDataSource
import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.repository.AssetRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AssetRepositoryImpl @Inject constructor(
    private val assetDataSource: AssetDataSource
) : AssetRepository {
    override suspend fun getAssets(): List<Asset> {
        return withContext(Dispatchers.IO) {
            assetDataSource.getAssets()
        }
    }

    override suspend fun getAssetById(id: Int): Asset? = assetDataSource.getAssetById(id)
}
