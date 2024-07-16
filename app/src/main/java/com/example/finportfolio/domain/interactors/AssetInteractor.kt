package com.example.finportfolio.domain.interactors

import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.repository.AssetRepository
import javax.inject.Inject

class AssetInteractor @Inject constructor(
    private val repository: AssetRepository
) {
    fun getAssets(): List<Asset> {
        return repository.getAssets()
    }

    fun getAssetById(id: Int): Asset? {
        return repository.getAssetById(id)
    }
}
