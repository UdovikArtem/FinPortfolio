package com.example.finportfolio.fragments.setting.stringselector

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.example.finportfolio.databinding.BottomSheetFragmentBinding
import com.example.finportfolio.databinding.ItemBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyStringSelector : BottomSheetDialogFragment() {
    private companion object {
        const val KEY_CURRENCY = "currencyKey"
        const val CURRENCY_NAME = "currencyName"
    }

    private lateinit var binding: BottomSheetFragmentBinding
    private val viewModel by viewModels<CurrencyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currencies.observe(viewLifecycleOwner) {
            binding.bottomSheetLayout.removeAllViews()
            it.forEach { currency ->
                val itemBottomSheetBinding = ItemBottomSheetBinding
                    .inflate(LayoutInflater.from(this.context))
                val textView = itemBottomSheetBinding.currencyText
                textView.text = currency.currencyName
                textView.setOnClickListener {
                    setFragmentResult(
                        KEY_CURRENCY,
                        bundleOf(CURRENCY_NAME to currency.currencyName)
                    )
                    dismiss()
                }
                binding.bottomSheetLayout.addView(textView)
            }
        }
    }
}
