package com.example.finportfolio.fragments.assetdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finportfolio.R
import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.entity.CurrencyRate
import com.example.finportfolio.domain.entity.PortfolioAsset
import com.example.finportfolio.domain.interactors.AssetInteractor
import com.example.finportfolio.domain.interactors.CurrencyRateInteractor
import com.example.finportfolio.domain.interactors.PortfolioInteractor
import com.example.finportfolio.domain.repository.SettingStore
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AssetDetailsViewModel @Inject constructor(
    private val assetInteractor: AssetInteractor,
    private val portfolioInteractor: PortfolioInteractor,
    private val settingStore: SettingStore,
    private val currencyRateInteractor: CurrencyRateInteractor
) : ViewModel() {
    private val _assetModel = MutableLiveData<Asset>()
    val assetModel: LiveData<Asset> = _assetModel
    private val _currencyRate = MutableLiveData<CurrencyRate>()
    private val _toastMessage = MutableLiveData<Int>()
    val toastMessage: LiveData<Int> = _toastMessage

    fun getAsset(id: Int) {
        viewModelScope.launch {
            _assetModel.value = assetInteractor.getAssetById(id)
            _currencyRate.value =
                currencyRateInteractor.getCurrencyRate(settingStore.getDefaultCurrency())
            if (_currencyRate.value!!.abbreviation != settingStore.getDefaultCurrency()) {
                _toastMessage.value = R.string.using_byn
            } else if (LocalDate.parse(_currencyRate.value!!.data.subSequence(0, 10))
                != LocalDate.now()
            ) {
                _toastMessage.value = R.string.not_relevant_rate
            }
        }
    }

    fun addAssetToPortfolio(value: Float) {
        viewModelScope.launch {
            _assetModel.value?.let {
                PortfolioAsset(
                    0,
                    it,
                    currencyRateInteractor.convertCurrencyToByn(_currencyRate.value!!, value),
                    LocalDate.now()
                )
            }?.let { portfolioInteractor.addPortfolioAsset(it) }
        }
    }
}
