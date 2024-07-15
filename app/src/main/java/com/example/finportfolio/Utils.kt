package com.example.finportfolio

import android.content.Context
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP

fun Int.dpToPx(context: Context): Int {
    return TypedValue.applyDimension(
        COMPLEX_UNIT_DIP,
        this.toFloat(),
        context.resources.displayMetrics
    ).toInt()
}
