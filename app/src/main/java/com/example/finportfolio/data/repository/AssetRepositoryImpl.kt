package com.example.finportfolio.data.repository

import com.example.finportfolio.data.db.dao.AssetDao
import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.repository.AssetRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AssetRepositoryImpl @Inject constructor(
    private val assetDao: AssetDao
) : AssetRepository {
    override suspend fun getAssets(): List<Asset> {
        return withContext(Dispatchers.IO) {
            assetDao.getAssets().map { it.toAsset() }
        }
    }

    override suspend fun getAssetById(id: Int): Asset? = withContext(Dispatchers.IO) {
        assetDao.getAssetById(id)?.toAsset()
    }
}
