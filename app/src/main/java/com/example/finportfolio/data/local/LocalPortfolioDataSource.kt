package com.example.finportfolio.data.local

import com.example.finportfolio.domain.datasource.PortfolioDataSource
import com.example.finportfolio.domain.entity.Cash
import com.example.finportfolio.domain.entity.Currency
import com.example.finportfolio.domain.entity.PortfolioAsset
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalPortfolioDataSource @Inject constructor() : PortfolioDataSource {
    private var id = 2
    private val portfolioAssetsList = mutableListOf<PortfolioAsset>(
        PortfolioAsset(
            id = 1,
            asset = Cash(
                id = 1,
                name = "Belarusian Ruble",
                currency = Currency.BYN
            ),
            value = 100,
            purchaseDate = LocalDate.of(2024, 7, 31)
        )
    )

    override suspend fun getPortfolioAssets(): List<PortfolioAsset> {
        return withContext(Dispatchers.IO) { portfolioAssetsList }
    }

    override suspend fun addPortfolioAsset(asset: PortfolioAsset) {
        withContext(Dispatchers.IO) {
            portfolioAssetsList.add(
                PortfolioAsset(
                    id,
                    asset.asset,
                    asset.value,
                    asset.purchaseDate
                )
            )
            id++
        }
    }

    override suspend fun deletePortfolioAsset(asset: PortfolioAsset) {
        withContext(Dispatchers.IO) {
            portfolioAssetsList.remove(asset)
        }
    }

    override suspend fun deleteListOfPortfolioAsset(assets: List<PortfolioAsset>) {
        withContext(Dispatchers.IO) {
            portfolioAssetsList.removeAll(assets)
        }
    }
}
