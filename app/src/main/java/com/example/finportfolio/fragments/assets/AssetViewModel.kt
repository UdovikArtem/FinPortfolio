package com.example.finportfolio.fragments.assets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.interactors.AssetInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AssetViewModel @Inject constructor(
    private val assetInteractor: AssetInteractor
) : ViewModel() {

    private val _assetsModel = MutableLiveData<List<Asset>>()
    val assetsModel: LiveData<List<Asset>> = _assetsModel

    init {
        _assetsModel.value = assetInteractor.getAssets()
    }
}
