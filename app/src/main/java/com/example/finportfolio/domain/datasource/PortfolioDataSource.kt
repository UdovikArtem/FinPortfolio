package com.example.finportfolio.domain.datasource

import com.example.finportfolio.domain.entity.PortfolioAsset

interface PortfolioDataSource {
    fun getPortfolioAssets(): List<PortfolioAsset>
    fun addPortfolioAsset(asset: PortfolioAsset)
    fun deletePortfolioAsset(asset: PortfolioAsset)
}
