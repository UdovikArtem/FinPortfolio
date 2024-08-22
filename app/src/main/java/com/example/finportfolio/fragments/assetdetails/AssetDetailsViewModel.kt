package com.example.finportfolio.fragments.assetdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.entity.PortfolioAsset
import com.example.finportfolio.domain.interactors.AssetInteractor
import com.example.finportfolio.domain.interactors.PortfolioInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AssetDetailsViewModel @Inject constructor(
    private val assetInteractor: AssetInteractor,
    private val portfolioInteractor: PortfolioInteractor
) : ViewModel() {
    private val _assetModel = MutableLiveData<Asset>()
    val assetModel: LiveData<Asset> = _assetModel

    fun getAsset(id: Int) {
        viewModelScope.launch {
            _assetModel.value = assetInteractor.getAssetById(id)
        }
    }

    fun addAssetToPortfolio(value: Float) {
        viewModelScope.launch {
            _assetModel.value?.let {
                PortfolioAsset(
                    0,
                    it,
                    value,
                    LocalDate.now()
                )
            }?.let { portfolioInteractor.addPortfolioAsset(it) }
        }
    }
}
