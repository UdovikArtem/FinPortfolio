package com.example.finportfolio.fragments.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.finportfolio.databinding.FragmentSettingBinding
import com.example.finportfolio.fragments.BaseFragment
import com.example.finportfolio.fragments.setting.stringSelector.BottomStringSelector
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
        binding.apply {
            binding.defaultCurrency.setOnClickListener {
                val bottomStringSelector = BottomStringSelector {
                    viewModel.setDefaultCurrency(it)
                }
                bottomStringSelector.show(parentFragmentManager, "currency")
            }
            viewModel.currencyModel.observe(viewLifecycleOwner) {
                currencyText.text = it
            }
        }
    }
}
