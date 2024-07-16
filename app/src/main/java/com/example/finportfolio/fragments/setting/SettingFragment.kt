package com.example.finportfolio.fragments.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.example.finportfolio.R
import com.example.finportfolio.databinding.FragmentSettingBinding
import com.example.finportfolio.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingBinding>() {

    private val viewModel by viewModels<SettingViewModel>()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSettingBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currency = resources.getStringArray(R.array.currency_array)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            currency
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.apply {
            currencySpinner.adapter = adapter
            viewModel.currencyModel.observe(viewLifecycleOwner) {
                val itemNumber = currency.indexOf(it)
                currencySpinner.setSelection(itemNumber)
            }
            saveButton.setOnClickListener {
                val selectedCurrency = binding.currencySpinner.selectedItem.toString()
                viewModel.setDefaultCurrency(selectedCurrency)
            }
        }
    }
}
