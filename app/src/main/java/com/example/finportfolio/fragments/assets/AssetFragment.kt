package com.example.finportfolio.fragments.assets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finportfolio.databinding.FragmentAssetBinding
import com.example.finportfolio.fragments.BaseFragment
import com.example.finportfolio.rv.AssetAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssetFragment : BaseFragment<FragmentAssetBinding>() {

    private val viewModel by viewModels<AssetViewModel>()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAssetBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AssetAdapter {
            val action = AssetFragmentDirections.actionAssetFragmentToAssetDetailsFragment(it.id)
            findNavController().navigate(action)
        }
        binding.recycler.adapter = adapter
        viewModel.assetsModel.observe(viewLifecycleOwner) { assets ->
            adapter.submitItems(assets)
        }
    }
}
