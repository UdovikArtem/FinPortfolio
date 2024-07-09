package com.example.finportfolio.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.finportfolio.databinding.ItemAssetBinding
import com.example.finportfolio.entity.Asset

class AssetViewHolder(private val binding: ItemAssetBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(asset: Asset, onClick: (Asset) -> Unit) {
        binding.apply {
            tvId.text = asset.id.toString()
            tvName.text = asset.name
            root.setOnClickListener { onClick(asset) }
        }
    }
}
