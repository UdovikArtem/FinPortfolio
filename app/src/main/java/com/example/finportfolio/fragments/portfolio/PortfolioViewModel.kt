package com.example.finportfolio.fragments.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finportfolio.domain.entity.PortfolioAsset
import com.example.finportfolio.domain.interactors.PortfolioInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val portfolioInteractor: PortfolioInteractor
) : ViewModel() {

    private var deleteJob: Job? = null
    private val _portfolioModel = MutableLiveData<List<PortfolioAsset>>()
    val portfolioModel: LiveData<List<PortfolioAsset>> = _portfolioModel
    private val _portfolioToDeleteModel = MutableLiveData<MutableList<PortfolioAsset>>()

    init {
        loadPortfolioAsset()
        _portfolioToDeleteModel.value = mutableListOf()
    }

    fun deletePortfolioAsset(asset: PortfolioAsset) {
        deleteJob = viewModelScope.launch {
            _portfolioToDeleteModel.value?.add(asset)
            delay(4000L)
            portfolioInteractor.deletePortfolioAsset(asset)
            loadPortfolioAsset()
        }
    }

    fun restorePortfolioAsset() {
        viewModelScope.launch {
            deleteJob?.cancel()
            _portfolioToDeleteModel.value?.clear()
        }
    }

    private fun loadPortfolioAsset() {
        viewModelScope.launch {
            _portfolioModel.value = portfolioInteractor.getPortfolioAssets()
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
