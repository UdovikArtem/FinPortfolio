package com.example.finportfolio.fragments.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.finportfolio.BaseFragment
import com.example.finportfolio.databinding.FragmentPortfolioBinding

class PortfolioFragment : BaseFragment<FragmentPortfolioBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPortfolioBinding = FragmentPortfolioBinding.inflate(inflater, container, false)
}