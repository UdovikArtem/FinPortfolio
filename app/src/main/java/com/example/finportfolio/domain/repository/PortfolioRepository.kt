package com.example.finportfolio.domain.repository

import com.example.finportfolio.domain.entity.PortfolioAsset

interface PortfolioRepository {
    fun getPortfolioAssets(): List<PortfolioAsset>
    fun addPortfolioAsset(asset: PortfolioAsset)
    fun deletePortfolioAsset(asset: PortfolioAsset)
}
