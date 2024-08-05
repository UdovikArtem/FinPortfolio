package com.example.finportfolio.fragments.assetdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.interactors.AssetInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AssetDetailsViewModel @Inject constructor(
    private val assetInteractor: AssetInteractor
) : ViewModel() {
    private val _assetModel = MutableLiveData<Asset>()
    val assetModel: LiveData<Asset> = _assetModel

    fun getAsset(id: Int) {
        viewModelScope.launch {
            _assetModel.value = assetInteractor.getAssetById(id)
        }
    }
}
