package com.yyc.wclib.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yyc.baselib.utils.CreatUtil
import com.yyc.baselib.utils.L
import com.yyc.wclib.base.BaseFragment

abstract class MvpBaseFragment<V: BaseView,P : BasePresenter<V,*> >: BaseFragment(){
    var mPresenter: P? =null//可空类型

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mPresenter = CreatUtil.getT(this,1)
        L.e( "mPresenter: $mPresenter")
        mPresenter?.bindView(this as V)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = CreatUtil.getT(this,1)
        super.onCreate(savedInstanceState)
        L.e( "mPresenter: $mPresenter")
        mPresenter?.bindView(this as V)
    }*/

    override fun initView() {

    }

    override fun initData() {
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unBindView()
    }
}
