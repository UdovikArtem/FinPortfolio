package com.example.finportfolio.fragments.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finportfolio.domain.entity.PortfolioAsset
import com.example.finportfolio.domain.interactors.PortfolioInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val portfolioInteractor: PortfolioInteractor
) : ViewModel() {

    private val _portfolioModel = MutableLiveData<List<PortfolioAsset>>()
    val portfolioModel: LiveData<List<PortfolioAsset>> = _portfolioModel

    init {
        viewModelScope.launch {
            _portfolioModel.value = portfolioInteractor.getPortfolioAssets()
        }
    }
}
