package com.castiel.common.widget

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.castiel.common.R
import com.scwang.smart.refresh.layout.api.RefreshFooter
import com.scwang.smart.refresh.layout.api.RefreshKernel
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.constant.RefreshState
import com.scwang.smart.refresh.layout.constant.SpinnerStyle

@SuppressLint("RestrictedApi")
class MsbRefreshFooter(context: Context) : LinearLayout(context), RefreshFooter {


    init {
//        setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        gravity = Gravity.CENTER_HORIZONTAL;
        addView(LayoutInflater.from(context).inflate(R.layout.layout_footer_view, this, false))
    }

    override fun getSpinnerStyle(): SpinnerStyle {
        return SpinnerStyle.Translate
    }

    override fun onFinish(refreshLayout: RefreshLayout, success: Boolean): Int {
        return 0
    }

    override fun onInitialized(kernel: RefreshKernel, height: Int, maxDragHeight: Int) {

    }

    override fun onHorizontalDrag(percentX: Float, offsetX: Int, offsetMax: Int) {

    }

    override fun setNoMoreData(noMoreData: Boolean): Boolean {
        return noMoreData
    }

    override fun onReleased(refreshLayout: RefreshLayout, height: Int, maxDragHeight: Int) {

    }

    override fun getView(): View {
        return this
    }

    override fun setPrimaryColors(vararg colors: Int) {

    }

    override fun onStartAnimator(refreshLayout: RefreshLayout, height: Int, maxDragHeight: Int) {

    }

    override fun onStateChanged(
        refreshLayout: RefreshLayout,
        oldState: RefreshState,
        newState: RefreshState
    ) {

    }

    override fun onMoving(
        isDragging: Boolean,
        percent: Float,
        offset: Int,
        height: Int,
        maxDragHeight: Int
    ) {

    }

    override fun isSupportHorizontalDrag(): Boolean {
        return false
    }
}