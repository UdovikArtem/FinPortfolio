package com.example.finportfolio.fragments.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.finportfolio.databinding.FragmentPortfolioBinding
import com.example.finportfolio.fragments.BaseFragment

class PortfolioFragment : BaseFragment<FragmentPortfolioBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPortfolioBinding.inflate(inflater, container, false)
}
