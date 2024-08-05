package com.example.finportfolio.domain.datasource

import com.example.finportfolio.domain.entity.PortfolioAsset

interface PortfolioDataSource {
    suspend fun getPortfolioAssets(): List<PortfolioAsset>
    suspend fun addPortfolioAsset(asset: PortfolioAsset)
    suspend fun deletePortfolioAsset(asset: PortfolioAsset)
}
