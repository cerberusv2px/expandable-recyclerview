package com.v2px.sujin.expandables1

import android.support.v7.widget.helper.ItemTouchHelper
import com.daimajia.swipe.SimpleSwipeListener
import com.daimajia.swipe.SwipeLayout
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_child.*


open class ChildItem(var childName: String) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.text_child.text = childName
        viewHolder.child_cardview.setOnClickListener {
            println("$childName")
        }

        viewHolder.child_cardview.setOnLongClickListener {
            println("Long pressed $childName")
            false
        }

        viewHolder.swipe.showMode = SwipeLayout.ShowMode.LayDown
        viewHolder.swipe.addSwipeListener(object: SimpleSwipeListener() {
            override fun onOpen(layout: SwipeLayout?) {
               // YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout?.findViewById(R.id.trash))
            }
        })


        viewHolder.delete.setOnClickListener {
            println("Delete!!!: $childName")
            viewHolder.swipe.close()
        }

    }

    override fun getLayout() = R.layout.item_child

    override fun getSwipeDirs(): Int {
        return ItemTouchHelper.RIGHT
    }


}