package com.example.finportfolio.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.finportfolio.domain.entity.PortfolioAsset

class PortfolioDiffCallback(
    private val oldList: List<PortfolioAsset>,
    private val newList: List<PortfolioAsset>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
