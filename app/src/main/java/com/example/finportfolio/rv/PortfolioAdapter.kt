package com.example.finportfolio.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finportfolio.databinding.ItemPortfolioAssetCardBinding
import com.example.finportfolio.domain.entity.PortfolioAsset

class PortfolioAdapter : RecyclerView.Adapter<PortfolioViewHolder>() {

    private var assets = emptyList<PortfolioAsset>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        return PortfolioViewHolder(
            ItemPortfolioAssetCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun submitItems(newItems: List<PortfolioAsset>) {
        val diffResult = DiffUtil.calculateDiff(
            PortfolioDiffCallback(assets, newItems)
        )
        assets = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        val asset = assets[position]
        holder.bind(asset)
    }

    override fun getItemCount(): Int = assets.size
}
