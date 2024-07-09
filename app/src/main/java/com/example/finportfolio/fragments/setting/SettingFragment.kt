package com.example.finportfolio.fragments.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.finportfolio.R
import com.example.finportfolio.data.setting.SettingStore
import com.example.finportfolio.databinding.FragmentSettingBinding
import com.example.finportfolio.fragments.BaseFragment

class SettingFragment : BaseFragment<FragmentSettingBinding>() {

    private lateinit var settingStore: SettingStore

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingBinding =
        FragmentSettingBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingStore = SettingStore(requireContext())

        binding.apply {
            val adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.currency_array,
                android.R.layout.simple_spinner_item
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            currencySpinner.adapter = adapter

            val defaultCurrency = settingStore.getDefaultCurrency()
            setSpinnerToValue(currencySpinner, defaultCurrency)

            saveButton.setOnClickListener {
                val selectedCurrency = binding.currencySpinner.selectedItem.toString()
                settingStore.setDefaultCurrency(selectedCurrency)
            }
        }
    }

    private fun setSpinnerToValue(spinner: Spinner, value: String) {
        for (i in 0 until spinner.count) {
            if (spinner.getItemAtPosition(i) == value) {
                spinner.setSelection(i)
                break
            }
        }
    }
}
