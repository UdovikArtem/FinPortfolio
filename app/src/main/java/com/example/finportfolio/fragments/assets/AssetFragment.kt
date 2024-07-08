package com.example.finportfolio.fragments.assets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.finportfolio.databinding.FragmentAssetBinding
import com.example.finportfolio.entity.Asset
import com.example.finportfolio.repository.AssetRepository
import com.example.finportfolio.rv.AssetAdapter

class AssetFragment : Fragment() {
    private var _binding: FragmentAssetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAssetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AssetAdapter({})
        binding.recycler.adapter = adapter
        adapter.submitItems(AssetRepository.getAssets())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}