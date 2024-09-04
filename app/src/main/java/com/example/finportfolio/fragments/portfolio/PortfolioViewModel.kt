package com.example.finportfolio.fragments.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finportfolio.R
import com.example.finportfolio.domain.entity.CurrencyRate
import com.example.finportfolio.domain.entity.PortfolioAsset
import com.example.finportfolio.domain.interactors.CurrencyRateInteractor
import com.example.finportfolio.domain.interactors.PortfolioInteractor
import com.example.finportfolio.domain.repository.SettingStore
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val portfolioInteractor: PortfolioInteractor,
    private val settingStore: SettingStore,
    private val currencyRateInteractor: CurrencyRateInteractor
) : ViewModel() {

    private var deleteJob: Job? = null
    private val _portfolioModel = MutableLiveData<List<PortfolioAsset>>()
    val portfolioModel: LiveData<List<PortfolioAsset>> = _portfolioModel
    private val _portfolioToDeleteModel = MutableLiveData<MutableList<PortfolioAsset>>()
    private val _currencyRate = MutableLiveData<CurrencyRate>()
    private val _toastMessage = MutableLiveData<Int>()
    val toastMessage: LiveData<Int> = _toastMessage

    init {
        loadPortfolioAsset()
        _portfolioToDeleteModel.value = mutableListOf()
    }

    fun deletePortfolioAsset(asset: PortfolioAsset) {
        deleteJob = viewModelScope.launch {
            _portfolioToDeleteModel.value?.add(asset)
            delay(4000L)
            portfolioInteractor.deletePortfolioAsset(asset)
        }
    }

    fun restorePortfolioAsset() {
        viewModelScope.launch {
            deleteJob?.cancel()
            _portfolioToDeleteModel.value?.removeLast()
        }
    }

    private fun loadPortfolioAsset() {
        viewModelScope.launch {
            val assets = portfolioInteractor.getPortfolioAssets()
            _currencyRate.value =
                currencyRateInteractor.getCurrencyRate(settingStore.getDefaultCurrency())

            if (_currencyRate.value!!.abbreviation != settingStore.getDefaultCurrency()) {
                _toastMessage.value = R.string.using_byn
            } else if (LocalDate.parse(_currencyRate.value!!.data.subSequence(0, 10))
                != LocalDate.now()
            ) {
                _toastMessage.value = R.string.not_relevant_rate
            }

            assets.forEach {
                it.value =
                    currencyRateInteractor.convertCurrencyFromByn(_currencyRate.value!!, it.value)
            }
            _portfolioModel.value = assets
        }
    }

    fun deletePortfolioAssetOnDestroy() {
        viewModelScope.launch {
            if (_portfolioToDeleteModel.value?.isEmpty() == false) {
                portfolioInteractor.deleteListOfPortfolioAsset(_portfolioToDeleteModel.value!!)
            }
        }
    }
}
