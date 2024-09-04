package com.example.finportfolio

import android.content.Context
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP

fun Float.dpToPx(context: Context): Float {
    return TypedValue.applyDimension(
        COMPLEX_UNIT_DIP,
        this,
        context.resources.displayMetrics
    )
}

fun Int.dpToPx(context: Context): Int {
    return TypedValue.applyDimension(
        COMPLEX_UNIT_DIP,
        this.toFloat(),
        context.resources.displayMetrics
    ).toInt()
}

fun Float.roundToTwoDecimalPlaces(): Float {
    return String.format("%.2f", this).toFloat()
}
