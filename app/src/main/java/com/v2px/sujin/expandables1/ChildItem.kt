package com.v2px.sujin.expandables1

import android.support.v7.widget.helper.ItemTouchHelper
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_child.*


open class ChildItem(var childName: String) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.text_child.text = childName
        viewHolder.child_cardview.setOnClickListener {
            println("${childName}")
        }
    }

    override fun getLayout() = R.layout.item_child

    override fun getSwipeDirs(): Int {
        return ItemTouchHelper.LEFT
    }

}