package com.example.finportfolio.fragments.assetdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.finportfolio.R
import com.example.finportfolio.databinding.FragmentAssetDetailsBinding
import com.example.finportfolio.domain.entity.Asset
import com.example.finportfolio.domain.entity.Cash
import com.example.finportfolio.domain.entity.Stock
import com.example.finportfolio.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssetDetailsFragment : BaseFragment<FragmentAssetDetailsBinding>() {

    private val viewModel by viewModels<AssetDetailsViewModel>()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAssetDetailsBinding = FragmentAssetDetailsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: AssetDetailsFragmentArgs by navArgs()
        val id = args.id

        viewModel.getAsset(id)
        viewModel.assetModel.observe(viewLifecycleOwner) {
            it?.let {
                bind(it)
            } ?: run {
                Toast.makeText(context, getString(R.string.asset_not_found), Toast.LENGTH_SHORT)
                    .show()
                findNavController().navigateUp()
            }
        }
    }

    private fun bind(asset: Asset) {
        with(binding) {
            name.text = asset.name
            when (asset) {
                is Cash -> {
                    valueType.setText(R.string.currency)
                    value.text = asset.currency.currencyName
                }

                is Stock -> {
                    valueType.setText(R.string.ticker)
                    value.text = asset.ticker
                }
            }
        }
    }
}