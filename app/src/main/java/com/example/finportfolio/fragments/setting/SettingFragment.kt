package com.example.finportfolio.fragments.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finportfolio.databinding.FragmentSettingBinding
import com.example.finportfolio.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingBinding>() {
    private companion object {
        const val KEY_CURRENCY = "currencyKey"
        const val CURRENCY_NAME = "currencyName"
    }

    private val viewModel by viewModels<SettingViewModel>()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSettingBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.defaultCurrency.setOnClickListener {
            val action =
                SettingFragmentDirections.actionSettingFragmentToCurrencyStringSelector()
            findNavController().navigate(action)
        }
        viewModel.currencyModel.observe(viewLifecycleOwner) {
            binding.currencyTextSelected.text = it
        }

        setFragmentResultListener(KEY_CURRENCY) { _, bundle ->
            val result = bundle.getString(CURRENCY_NAME)
            if (result != null) {
                viewModel.setDefaultCurrency(result)
            }
        }
    }
}
