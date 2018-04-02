package com.v2px.sujin.expandables1

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val gray: Int by lazy { ContextCompat.getColor(this, R.color.primary_material_dark) }

    enum class ButtonState {
        GONE,
        VISIBLE
    }

    lateinit var groupAdapter: GroupAdapter<ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        groupAdapter = GroupAdapter()
        recyclerMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = groupAdapter
        }

      //  ItemTouchHelper(touchCallback).attachToRecyclerView(recyclerMain)

        getData().forEach {
            ExpandableGroup(it, false).apply {
                add(Section(it.childList))
                groupAdapter.add(this)
            }
        }
    }

    /*private val touchCallback: SwipeTouchCallback by lazy {
        object : SwipeTouchCallback(gray) {
            private var swipeBack = false
            private var buttonShowState = ButtonState.GONE
            private  val buttonWidth = 300f
            private var buttonInstance: RectF? = null

            override fun onMove(recyclerView: RecyclerView,
                                viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = groupAdapter.getItem(viewHolder.adapterPosition)
                Toast.makeText(applicationContext, "swped", Toast.LENGTH_LONG).show()
            }


            override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {
                if (swipeBack) {
                    swipeBack = false
                    return 0
                }
                return super.convertToAbsoluteDirection(flags, layoutDirection)
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                if (actionState == ACTION_STATE_SWIPE) {
                    setTouchListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                drawButton(c, viewHolder)
            }

            private fun setTouchListener(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                recyclerMain.setOnTouchListener { _, event ->
                    swipeBack = event.action == MotionEvent.ACTION_CANCEL || event.action == MotionEvent.ACTION_UP
                    if (swipeBack) {
                        if (dX > buttonWidth) buttonShowState = ButtonState.VISIBLE

                        if (buttonShowState != ButtonState.GONE) {
                            setTouchDownListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                        }
                    }
                    false
                }
            }

            private fun setTouchDownListener(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                recyclerMain.setOnTouchListener { v, event ->
                    if (event.action == MotionEvent.ACTION_DOWN) {
                        setTouchUpListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    }
                    false
                }
            }

            private fun setTouchUpListener(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                recyclerMain.setOnTouchListener { v, event ->
                    if (event.action == MotionEvent.ACTION_UP) {
                        touchCallback.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                        recyclerMain.setOnTouchListener { v, event ->
                            false
                        }
                        setItemsClickable(recyclerMain, true)
                        swipeBack = false
                        buttonShowState = ButtonState.GONE
                    }
                    false
                }
            }

            private fun setItemsClickable(recyclerView: RecyclerView, isClickable: Boolean) {
                for (i in 0..recyclerView.childCount) {
                    recyclerView.getChildAt(i).isClickable = isClickable
                }
            }

            private fun drawButton(c: Canvas, viewHolder: RecyclerView.ViewHolder) {
                val buttonWidthoutPadding = buttonWidth - 20
                val corner = 2f

                val itemView = viewHolder.itemView
                var p = Paint()

                val rightButton = RectF(itemView.right - buttonWidthoutPadding, itemView.top.toFloat(), itemView.right.toFloat(), itemView.bottom.toFloat())
                p.color = Color.RED
                c.drawRoundRect(rightButton, corner, corner, p)
                drawText("DELETE", c, rightButton, p)
                buttonInstance = null
                if(buttonShowState == ButtonState.VISIBLE) {
                    buttonInstance = rightButton
                }

            }

            private fun drawText(text: String, c: Canvas, button: RectF, p: Paint) {
                val textSize = 60f
                p.color = Color.WHITE
                p.isAntiAlias = true
                p.textSize = textSize

                val textWidth = p.measureText(text)
                c.drawText(text, button.centerX() - (textWidth/2), button.centerY()+(textWidth/2), p)
            }
        }
    }*/

    private fun getData(): List<ParentItem> {
        return listOf(
                ParentItem("Iron Man",
                        listOf(
                                ChildItem("Iron man I"),
                                ChildItem("Iron man II"),
                                ChildItem("Iron man III"))
                ),
                ParentItem("Avengers",
                        listOf(
                                ChildItem("Avengers I"),
                                ChildItem("Age of Ultron"),
                                ChildItem("Infinity war"))
                )
        )
    }
}
