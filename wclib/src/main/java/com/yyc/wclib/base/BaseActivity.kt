package com.yyc.wclib.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import com.yyc.baselib.widget.CustomToolBar
import com.yyc.wclib.R

/**
 * Author: Austin
 * Date: 2018/10/8
 * Description: Activity基类
 */
abstract class BaseActivity : AppCompatActivity(), View.OnClickListener , CustomToolBar.OnClickLeftListener,CustomToolBar.OnClickRightListener {
    private val BASE_VIEW_ID: Int = R.layout.activity_base
    lateinit var mContext: Context
    lateinit var customToolBar: CustomToolBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initRootView())
        mContext = this
        initView()
        initData()
//DaggerActivityComponent.builder().applicationComponent(application as BaseApplication.ApplicationComponent)
    }

    private fun initRootView(): View {
        var baseView: LinearLayout = layoutInflater.inflate(BASE_VIEW_ID,null) as LinearLayout
        customToolBar = CustomToolBar(this)
        customToolBar.onClickLeftListener = this
        customToolBar.onClickRightListener = this
        baseView.addView(customToolBar)
        if (layoutId() != 0) {
            var subView: View = getLayoutInflater().inflate(layoutId(), null)
            var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT, 1.0f)
            subView.setLayoutParams(params)
            baseView.addView(subView)
        }
        return baseView
    }

    /**
     * 加载布局
     */
    abstract fun layoutId(): Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化 View
     */
    abstract fun initView()

    fun setToolbarTitle(title: String) {
            customToolBar.setTitle(title)
    }

    fun setToolbarTitle(title: Int) {
            customToolBar.setTitle(title)
    }

    fun showToolbar(visibility: Int) {
        customToolBar.visibility = visibility
    }

    override fun onClick(v: View?) {
        when(v?.id) {

        }
    }

    override fun onClickLeft(view: View) {
        finish()
    }

    override fun onClickRight(view: View) {

    }

    /*override fun onResume() {
        super.onResume()
        L.i("onResume")
    }

    override fun onStart() {
        super.onStart()
        L.i("onStart")
    }

    override fun onPause() {
        super.onPause()
        L.i("onPause")
    }

    override fun onStop() {
        super.onStop()
        L.i("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        L.i("onDestroy")
    }*/


}
