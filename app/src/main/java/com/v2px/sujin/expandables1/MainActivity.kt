package com.v2px.sujin.expandables1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val excitingSection = Section()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val child1 = generatedChildItem1()
        val child2 = generatedChildItem2()

        val groupAdapter = GroupAdapter<ViewHolder>()
        recyclerMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = groupAdapter
        }

        ExpandableGroup(ParentItem("praent1"), false).apply {
            add(Section(child1))
            groupAdapter.add(this)
        }

        ExpandableGroup(ParentItem("praent2"), false).apply {
            //excitingSection.addAll(child2)
            add(Section(child2))
            groupAdapter.add(this)
        }

        ExpandableGroup(ParentItem("praent3"), false).apply {
            //excitingSection.addAll(child1)
            //add(excitingSection)
            add(Section(child1))
            groupAdapter.add(this)
        }



    }

    private fun generatedChildItem1(): List<ChildItem> {
        return listOf(
                ChildItem("Chidl11"),
                ChildItem("Child12")
        )
    }

    private fun generatedChildItem2(): List<ChildItem> {
        return listOf(
                ChildItem("Chidl21"),
                ChildItem("Child22")
        )
    }

}
