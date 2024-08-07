package com.example.finportfolio.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.finportfolio.databinding.ItemPortfolioAssetCardBinding
import com.example.finportfolio.domain.entity.PortfolioAsset

class PortfolioAdapter :
    ListAdapter<PortfolioAsset, PortfolioViewHolder>(PortfolioDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        return PortfolioViewHolder(
            ItemPortfolioAssetCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun removeItem(position: Int) {
        val currentList = currentList.toMutableList()
        currentList.removeAt(position)
        submitList(currentList)
    }

    fun restoreItem(item: PortfolioAsset, position: Int) {
        val currentList = currentList.toMutableList()
        currentList.add(position, item)
        submitList(currentList)
    }
}
