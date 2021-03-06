package com.yyc.wclib.mvp

import android.os.Bundle
import android.util.Log
import com.yyc.baselib.utils.CreatUtil
import com.yyc.wclib.base.BaseActivity
abstract class MvpBaseActivity<V: BaseView,P : BasePresenter2<V,*> >: BaseActivity(){
    var mPresenter: P? =null//可空类型

    override fun onCreate(savedInstanceState: Bundle?) {
//        mPresenter = CreatUtilOne.getT(this,0)
        mPresenter = CreatUtil.getT(this,0)
        super.onCreate(savedInstanceState)
        Log.e("aa", "mPresenter: $mPresenter")
//        mPresenter?.attachView(this)
        mPresenter!!.bindView(this as V)
    }

    public abstract fun initPresenter(): P

    override fun initView() {
    }

    override fun initData() {
    }

    override fun onDestroy() {
        super.onDestroy()
//        mPresenter?.dettachView()
    }
}
