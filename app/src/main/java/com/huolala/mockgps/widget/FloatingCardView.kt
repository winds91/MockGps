package com.huolala.mockgps.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.prohua.roundlayout.RoundAngleFrameLayout


/**
 * @author jiayu.liu
 */
class FloatingCardView : RoundAngleFrameLayout {
    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }
}