package com.example.finportfolio.data.repository

import com.example.finportfolio.domain.datasource.PortfolioDataSource
import com.example.finportfolio.domain.entity.PortfolioAsset
import com.example.finportfolio.domain.repository.PortfolioRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PortfolioRepositoryImpl @Inject constructor(
    private val dataSource: PortfolioDataSource
) : PortfolioRepository {
    override suspend fun getPortfolioAssets(): List<PortfolioAsset> {
        return withContext(Dispatchers.IO) {
            dataSource.getPortfolioAssets()
        }
    }

    override suspend fun addPortfolioAsset(asset: PortfolioAsset) {
        return withContext(Dispatchers.IO) {
            dataSource.addPortfolioAsset(asset)
        }
    }

    override suspend fun deletePortfolioAsset(asset: PortfolioAsset) {
        return withContext(Dispatchers.IO) {
            dataSource.deletePortfolioAsset(asset)
        }
    }

    override suspend fun deleteListOfPortfolioAsset(assets: List<PortfolioAsset>) {
        withContext(Dispatchers.IO) {
            dataSource.deleteListOfPortfolioAsset(assets)
        }
    }
}
