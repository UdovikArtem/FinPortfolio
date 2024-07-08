package com.example.finportfolio.fragments.assets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.finportfolio.BaseFragment
import com.example.finportfolio.databinding.FragmentAssetBinding
import com.example.finportfolio.entity.Asset
import com.example.finportfolio.repository.AssetRepository
import com.example.finportfolio.rv.AssetAdapter

class AssetFragment : BaseFragment<FragmentAssetBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAssetBinding = FragmentAssetBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AssetAdapter({})
        binding.recycler.adapter = adapter
        adapter.submitItems(AssetRepository.getAssets())
    }
}