package com.yyc.wclib.mvp

import android.os.Bundle
import com.yyc.baselib.utils.CreatUtil
import com.yyc.baselib.utils.L
import com.yyc.wclib.base.BaseActivity
abstract class MvpBaseActivity<V: BaseView,P : BasePresenter<V,*> >: BaseActivity(){
    var mPresenter: P? =null//可空类型

    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = CreatUtil.getT(this,1)
        super.onCreate(savedInstanceState)
        L.e( "mPresenter: $mPresenter")
        mPresenter?.bindView(this as V)
    }

    override fun initView() {

    }

    override fun initData() {
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unBindView()
    }
}
