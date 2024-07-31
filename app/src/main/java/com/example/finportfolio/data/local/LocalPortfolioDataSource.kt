package com.example.finportfolio.data.local

import com.example.finportfolio.domain.datasource.PortfolioDataSource
import com.example.finportfolio.domain.entity.Cash
import com.example.finportfolio.domain.entity.Currency
import com.example.finportfolio.domain.entity.PortfolioAsset
import java.time.LocalDate
import javax.inject.Inject

class LocalPortfolioDataSource @Inject constructor() : PortfolioDataSource {
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

    override fun getPortfolioAssets() = portfolioAssetsList

    override fun addPortfolioAsset(asset: PortfolioAsset) {
        portfolioAssetsList.add(asset)
    }

    override fun deletePortfolioAsset(asset: PortfolioAsset) {
        portfolioAssetsList.remove(asset)
    }
}
