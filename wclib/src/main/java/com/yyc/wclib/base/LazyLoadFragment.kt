package com.yyc.wclib.base

import android.os.Bundle

abstract class LazyLoadFragment : BaseFragment() {

    /**
     * 是否初始化过布局
     */
    public var isViewInitiated: Boolean = false
    /**
     * 当前界面是否可见
     */
    public var isVisibleToUser: Boolean = false
    /**
     * 是否加载过数据
     */
    public var isDataInitiated: Boolean = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isViewInitiated = true
        prepareFetchData()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        if (isVisibleToUser) {
            prepareFetchData()
        }
    }

    /**
     * 懒加载
     */
    abstract fun lazyLoadData()

    /**
     * 判断懒加载条件
     *
     * @param forceUpdate 强制更新，好像没什么用？
     */
    @JvmOverloads
    fun prepareFetchData(forceUpdate: Boolean = false) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            lazyLoadData()
            isDataInitiated = true
        }
    }
}
