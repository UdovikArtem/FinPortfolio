package com.example.finportfolio.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.finportfolio.databinding.ItemPortfolioAssetCardBinding
import com.example.finportfolio.domain.entity.PortfolioAsset

class PortfolioViewHolder(private val binding: ItemPortfolioAssetCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(portfolioAsset: PortfolioAsset) {
        binding.apply {
            assetName.text = portfolioAsset.asset.name
            assetValue.text = portfolioAsset.value.toString()
            assetDate.text = portfolioAsset.purchaseDate.toString()
        }
    }
}
