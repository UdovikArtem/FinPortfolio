package com.example.finportfolio.fragments.setting.stringSelector

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setPadding
import com.example.finportfolio.R
import com.example.finportfolio.databinding.BottomSheetLayoutBinding
import com.example.finportfolio.dpToPx
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomStringSelector(
    private val textOnClickListener: (String) -> Unit
) : BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetLayoutBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currency = resources.getStringArray(R.array.currency_array)
        binding.currency.apply {
            currency.forEach {
                this.addView(addTextView(it))
            }
        }
    }

    private fun addTextView(currency: String): TextView {
        val textView = TextView(this.context).apply {
            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textSize = 20f
            text = currency
            setPadding(15.dpToPx(this.context))
        }
        textView.setOnClickListener {
            textOnClickListener(textView.text.toString())
            dismiss()
        }
        return textView
    }
}
