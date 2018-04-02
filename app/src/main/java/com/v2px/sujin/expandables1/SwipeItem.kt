package com.v2px.sujin.expandables1

import android.support.v7.widget.helper.ItemTouchHelper

class SwipeItem(title: String): ChildItem(title) {

    override fun getSwipeDirs(): Int {
        return ItemTouchHelper.LEFT
    }
}