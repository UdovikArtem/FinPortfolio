package com.example.finportfolio.data.repository

import com.example.finportfolio.domain.datasource.PortfolioDataSource
import com.example.finportfolio.domain.entity.PortfolioAsset
import com.example.finportfolio.domain.repository.PortfolioRepository
import javax.inject.Inject

class PortfolioRepositoryImpl @Inject constructor(
    private val dataSource: PortfolioDataSource
) : PortfolioRepository {
    override suspend fun getPortfolioAssets(): List<PortfolioAsset> {
        return dataSource.getPortfolioAssets()
    }

    override suspend fun addPortfolioAsset(asset: PortfolioAsset) {
        return dataSource.addPortfolioAsset(asset)
    }

    override suspend fun deletePortfolioAsset(asset: PortfolioAsset) {
        return dataSource.deletePortfolioAsset(asset)
    }
}
