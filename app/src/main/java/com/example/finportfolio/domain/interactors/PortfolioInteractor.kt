package com.example.finportfolio.domain.interactors

import com.example.finportfolio.domain.entity.PortfolioAsset
import com.example.finportfolio.domain.repository.PortfolioRepository
import javax.inject.Inject

class PortfolioInteractor @Inject constructor(
    private val repository: PortfolioRepository
) {
    suspend fun getPortfolioAssets() = repository.getPortfolioAssets()

    suspend fun addPortfolioAsset(asset: PortfolioAsset) {
        return repository.addPortfolioAsset(asset)
    }

    suspend fun deletePortfolioAsset(asset: PortfolioAsset) {
        return repository.deletePortfolioAsset(asset)
    }
}
