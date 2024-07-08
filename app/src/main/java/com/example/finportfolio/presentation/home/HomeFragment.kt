package com.example.finportfolio.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finportfolio.BaseFragment
import com.example.finportfolio.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val action = HomeFragmentDirections.actionHomeFragmentToSettingsFragment()
        binding.apply {
            buttonSettings.setOnClickListener {
                findNavController().navigate(action)
            }
        }
    }
}