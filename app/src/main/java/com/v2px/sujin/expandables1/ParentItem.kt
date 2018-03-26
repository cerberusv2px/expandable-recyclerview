package com.v2px.sujin.expandables1

import android.support.v7.view.menu.ExpandedMenuView
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_parent.*


class ParentItem(var title: String) : Item(), ExpandableItem{

    private lateinit var expandableGroup: ExpandableGroup

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.text_parent.text = title
        viewHolder.parent_item.setOnClickListener {
            expandableGroup.onToggleExpanded()
        }
    }

    override fun getLayout() = R.layout.item_parent
}