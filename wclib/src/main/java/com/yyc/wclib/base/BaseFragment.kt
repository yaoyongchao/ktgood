package com.yyc.wclib.base

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yyc.baselib.widget.CustomToolBar

/**
 * Author: Austin
 * Date: 2018/10/8
 * Description: Activity基类
 */
abstract class BaseFragment : Fragment(), View.OnClickListener , CustomToolBar.OnClickLeftListener,CustomToolBar.OnClickRightListener {
//    private val BASE_VIEW_ID: Int = R.layout.activity_base
    lateinit var mContext: Context
//    lateinit var customToolBar: CustomToolBar


    lateinit var rootView: View

    /*override fun onAttach(context: Context?) {
        this.mContext = context?
        super.onAttach(context)
    }*/
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater!!.inflate(layoutId(), container, false)
        this.mContext = rootView.context
        initView()
        initData()
        return rootView

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



    override fun onClick(v: View?) {
        when(v?.id) {

        }
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
