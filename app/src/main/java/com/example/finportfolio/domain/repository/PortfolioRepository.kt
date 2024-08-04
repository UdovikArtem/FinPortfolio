package com.example.finportfolio.domain.repository

import com.example.finportfolio.domain.entity.PortfolioAsset

interface PortfolioRepository {
    suspend fun getPortfolioAssets(): List<PortfolioAsset>
    suspend fun addPortfolioAsset(asset: PortfolioAsset)
    suspend fun deletePortfolioAsset(asset: PortfolioAsset)
}
