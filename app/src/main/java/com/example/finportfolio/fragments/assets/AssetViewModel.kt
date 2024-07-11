package com.example.finportfolio.fragments.assets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finportfolio.entity.Asset
import com.example.finportfolio.repository.AssetRepository

class AssetViewModel : ViewModel() {

    private val _model = MutableLiveData<List<Asset>>()
    val model: LiveData<List<Asset>> = _model

    init {
        _model.value = AssetRepository.getAssets()
    }
}
