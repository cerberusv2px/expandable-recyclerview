package com.v2px.sujin.expandables1

import android.graphics.Canvas
import android.graphics.Paint
import android.support.annotation.ColorInt
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.xwray.groupie.TouchCallback


abstract class SwipeTouchCallback(@param:ColorInt @field:ColorInt private val backgroundColor: Int) : TouchCallback() {

    private val paint: Paint = Paint()

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        if (ItemTouchHelper.ACTION_STATE_SWIPE == actionState) {
            val child = viewHolder.itemView
            val lm = recyclerView.layoutManager

            // Fade out the item
           // child.alpha = 1 - Math.abs(dX) / child.width as Float

        }

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}