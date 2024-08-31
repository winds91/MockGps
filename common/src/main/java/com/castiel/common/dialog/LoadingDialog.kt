package com.castiel.common.dialog

import android.content.Context
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.castiel.common.R

class LoadingDialog(context: Context) : BaseDialog(context) {

    init {
        val view: View = layoutInflater.inflate(R.layout.dialog_loading, ConstraintLayout(context))
        setContentView(view)
        setCanceledOnTouchOutside(false)
    }

}