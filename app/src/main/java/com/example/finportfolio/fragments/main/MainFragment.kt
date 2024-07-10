package com.example.finportfolio.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finportfolio.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actionPortfolio = MainFragmentDirections.actionMainFragmentToPortfolioFragment()
        val actionAsset = MainFragmentDirections.actionMainFragmentToAssetFragment()

        binding.buttonFragmentPortfolio.setOnClickListener {
            findNavController().navigate(actionPortfolio)
        }

        binding.buttonFragmentAsset.setOnClickListener {
            findNavController().navigate(actionAsset)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
