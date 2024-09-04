package com.example.finportfolio.data.repository

import com.example.finportfolio.data.db.dao.PortfolioAssetDao
import com.example.finportfolio.data.db.entity.PortfolioAssetDbEntity
import com.example.finportfolio.domain.entity.PortfolioAsset
import com.example.finportfolio.domain.repository.PortfolioRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PortfolioRepositoryImpl @Inject constructor(
    private val portfolioAssetDao: PortfolioAssetDao
) : PortfolioRepository {
    override suspend fun getPortfolioAssets(): List<PortfolioAsset> {
        return withContext(Dispatchers.IO) {
            portfolioAssetDao.getPortfolioAssets().map { it.toPortfolioAsset() }
        }
    }

    override suspend fun addPortfolioAsset(asset: PortfolioAsset) {
        return withContext(Dispatchers.IO) {
            portfolioAssetDao.addPortfolioAsset(PortfolioAssetDbEntity.fromDomain(asset))
        }
    }

    override suspend fun deletePortfolioAsset(asset: PortfolioAsset) {
        return withContext(Dispatchers.IO) {
            portfolioAssetDao.deletePortfolioAsset(PortfolioAssetDbEntity.fromDomain(asset))
        }
    }

    override suspend fun deleteListOfPortfolioAsset(assets: List<PortfolioAsset>) {
        withContext(Dispatchers.IO) {
            portfolioAssetDao.deleteListOfPortfolioAsset(
                assets.map {
                    PortfolioAssetDbEntity.fromDomain(it)
                }
            )
        }
    }
}
