package com.castiel.common.recycler.decoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.blankj.utilcode.util.ConvertUtils

/**
 * 竖向recycleView分割线LinearLayoutManager
 * @author jiayu.liu
 */
class VerticalItemDecoration constructor(
    context: Context,
    drawable: Int,
    left: Float,
    right: Float
) : ItemDecoration() {
    private val mDivider: Drawable? = ContextCompat.getDrawable(context,drawable)
    private val left: Int = ConvertUtils.dp2px(left)
    private val right: Int = ConvertUtils.dp2px(right)

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount
        //最后一个item不画分割线
        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + (mDivider?.intrinsicHeight ?: 0)
            mDivider?.setBounds(left + this.left, top, right - this.right, bottom)
            mDivider?.draw(c)
        }
    }

}