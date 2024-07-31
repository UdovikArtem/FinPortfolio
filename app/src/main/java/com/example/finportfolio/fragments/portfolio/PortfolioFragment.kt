package com.example.finportfolio.fragments.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.finportfolio.databinding.FragmentPortfolioBinding
import com.example.finportfolio.fragments.BaseFragment
import com.example.finportfolio.rv.PortfolioAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PortfolioFragment : BaseFragment<FragmentPortfolioBinding>() {

    private val viewModel by viewModels<PortfolioViewModel>()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPortfolioBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PortfolioAdapter()
        binding.portfolioRecycler.adapter = adapter
        viewModel.portfolioModel.observe(viewLifecycleOwner) { portfolioAssets ->
            adapter.submitItems(portfolioAssets)
        }
    }
}
