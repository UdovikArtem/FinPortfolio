package com.example.finportfolio.rv.swipecallback

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.finportfolio.R
import com.example.finportfolio.dpToPx

abstract class SwipeDeleteCallback internal constructor(private val mContext: Context?) :
    ItemTouchHelper.Callback() {
    private val mClearPaint = Paint()
    private var mBackground: ShapeDrawable
    private val backgroundColor = mContext?.let { ContextCompat.getColor(it, R.color.red) }
    private val deleteDrawable: Drawable?
    private val intrinsicWidth: Int
    private val intrinsicHeight: Int

    init {
        mClearPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        deleteDrawable =
            mContext?.let { ContextCompat.getDrawable(it, android.R.drawable.ic_menu_delete) }
        intrinsicWidth = deleteDrawable!!.intrinsicWidth
        intrinsicHeight = deleteDrawable.intrinsicHeight

        val radii = mContext?.let {
            floatArrayOf(
                2f.dpToPx(it),
                2f.dpToPx(it),
                2f.dpToPx(it),
                2f.dpToPx(it),
                2f.dpToPx(it),
                2f.dpToPx(it),
                2f.dpToPx(it),
                2f.dpToPx(it)
            )
        }
        val roundRectShape = RoundRectShape(radii, null, null)

        mBackground = ShapeDrawable(roundRectShape)
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(0, ItemTouchHelper.LEFT)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        val itemView = viewHolder.itemView
        val itemHeight = itemView.height

        val isCancelled = dX == 0f && !isCurrentlyActive

        if (isCancelled) {
            clearCanvas(
                c,
                itemView.right + dX,
                itemView.top.toFloat(),
                itemView.right.toFloat(),
                itemView.bottom.toFloat()
            )
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            return
        }

        val radiiOfCorner = (itemHeight / 2).toFloat()

        val radii = mContext?.let {
            floatArrayOf(
                radiiOfCorner.dpToPx(it),
                radiiOfCorner.dpToPx(it),
                radiiOfCorner.dpToPx(it),
                radiiOfCorner.dpToPx(it),
                radiiOfCorner.dpToPx(it),
                radiiOfCorner.dpToPx(it),
                radiiOfCorner.dpToPx(it),
                radiiOfCorner.dpToPx(it)
            )
        }

        mBackground = ShapeDrawable(RoundRectShape(radii, null, null))
        mBackground.paint.color = backgroundColor ?: Color.RED

        mContext?.let {
            mBackground.setBounds(
                itemView.right + dX.toInt() + 20.dpToPx(it),
                itemView.top,
                itemView.right,
                itemView.bottom
            )
        }
        mBackground.draw(c)
        val deleteIconTop = itemView.top + (itemHeight - intrinsicHeight) / 2
        val deleteIconMargin = (itemHeight - intrinsicHeight) / 2
        val deleteIconLeft = itemView.right - deleteIconMargin - intrinsicWidth
        val deleteIconRight = itemView.right - deleteIconMargin
        val deleteIconBottom = deleteIconTop + intrinsicHeight
        mContext?.let {
            if (dX.toInt() < (-itemHeight / 2) - 20f.dpToPx(it)) {
                deleteDrawable!!.setBounds(
                    deleteIconLeft, deleteIconTop, deleteIconRight, deleteIconBottom
                )
                deleteDrawable.draw(c)
            }
        }

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    private fun clearCanvas(c: Canvas, left: Float, top: Float, right: Float, bottom: Float) {
        c.drawRect(left, top, right, bottom, mClearPaint)
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 0.7f
    }
}
