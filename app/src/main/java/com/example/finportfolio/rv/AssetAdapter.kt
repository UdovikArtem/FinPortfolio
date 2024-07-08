package com.example.finportfolio.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finportfolio.databinding.ItemAssetBinding
import com.example.finportfolio.entity.Asset

class AssetAdapter(private val onClick: (Asset) -> Unit) : RecyclerView.Adapter<AssetViewHolder>() {

    private var assets = emptyList<Asset>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        return AssetViewHolder(
            ItemAssetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun submitItems(newItems: List<Asset>) {
        val diffResult = DiffUtil.calculateDiff(
            AssetDiffCallback(assets, newItems)
        )
        assets = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        val asset = assets[position]
        holder.bind(asset, onClick)
    }

    override fun getItemCount(): Int = assets.size
}