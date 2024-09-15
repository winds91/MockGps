package com.huolala.mockgps.ui

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.castiel.common.base.BaseActivity
import com.castiel.common.base.BaseViewModel
import com.castiel.common.recycler.decoration.VerticalItemDecoration
import com.huolala.mockgps.R
import com.huolala.mockgps.adaper.SettingAdapter
import com.huolala.mockgps.databinding.ActivitySettingBinding
import com.huolala.mockgps.model.SettingMsgModel
import com.huolala.mockgps.utils.MMKVUtils

/**
 * @author jiayu.liu
 */
class SettingActivity : BaseActivity<ActivitySettingBinding, BaseViewModel>() {
    private var mAdapter: SettingAdapter? = null
    private val mTitle = arrayOf(
        "模拟定位震动功能",
        "模拟导航经纬度绑路功能",
    )
    private val mMsg = arrayOf(
        "定位开启后，自动微调参数(方向、经纬度等)",
        "模拟导航计算增加绑路功能，提高精度。注意：性能有所降低！",
    )

    override fun initViewModel(): Class<BaseViewModel> {
        return BaseViewModel::class.java
    }

    override fun getLayout(): Int {
        return R.layout.activity_setting
    }

    override fun initView() {
        setSupportActionBar(dataBinding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true) // 显示返回按钮
        supportActionBar!!.setHomeAsUpIndicator(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_back_light
            )
        )  // 设置返回按钮图标
        dataBinding.toolbar.setNavigationOnClickListener {
            onBackPressed() // 或者在这里添加返回按钮点击后的操作
        }
        dataBinding.recycler.layoutManager = LinearLayoutManager(this)
        mAdapter = SettingAdapter()
        dataBinding.recycler.adapter = mAdapter
        dataBinding.recycler.addItemDecoration(
            VerticalItemDecoration(
                this,
                com.castiel.common.R.drawable.shape_item_line_verticall,
                10f,
                0f
            )
        )

        mAdapter?.listener = object : SettingAdapter.OnItemListener {
            override fun onItemSwitch(view: View?, model: SettingMsgModel, isChecked: Boolean) {
                when (model.title) {
                    mTitle[0] -> MMKVUtils.saveSettingConfig(
                        MMKVUtils.KEY_LOCATION_VIBRATION,
                        isChecked
                    )
                    mTitle[1] -> MMKVUtils.saveSettingConfig(
                        MMKVUtils.KEY_NAVI_ROUTE_BINDING,
                        isChecked
                    )
                    else -> {}
                }
            }

        }
    }

    override fun initData() {
        val settingModel = MMKVUtils.getSettingModel()
        mAdapter?.submitList(
            mutableListOf(
                SettingMsgModel(
                    title = mTitle[0],
                    msg = mMsg[0],
                    isSwitch = settingModel.isLocationQuiver
                ),
                SettingMsgModel(
                    title = mTitle[1],
                    msg = mMsg[1],
                    isSwitch = settingModel.isNaviRouteBinding
                )
            )
        )
    }

    override fun initObserver() {
    }


}