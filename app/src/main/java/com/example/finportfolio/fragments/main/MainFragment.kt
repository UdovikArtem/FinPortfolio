package com.example.finportfolio.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finportfolio.databinding.FragmentMainBinding
import com.example.finportfolio.fragments.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actionPortfolio = MainFragmentDirections.actionMainFragmentToPortfolioFragment()
        val actionAsset = MainFragmentDirections.actionMainFragmentToAssetFragment()
        val actionSetting = MainFragmentDirections.actionMainFragmentToSettingFragment()

        binding.apply {
            buttonFragmentPortfolio.setOnClickListener {
                findNavController().navigate(actionPortfolio)
            }

            buttonFragmentAsset.setOnClickListener {
                findNavController().navigate(actionAsset)
            }

            buttonSettings.setOnClickListener {
                findNavController().navigate(actionSetting)
            }
        }
    }
}
