package com.example.finportfolio.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.finportfolio.domain.entity.PortfolioAsset

class PortfolioDiffCallback : DiffUtil.ItemCallback<PortfolioAsset>() {
    override fun areItemsTheSame(oldItem: PortfolioAsset, newItem: PortfolioAsset): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PortfolioAsset, newItem: PortfolioAsset): Boolean {
        return oldItem == newItem
    }
}
