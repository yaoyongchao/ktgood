package com.yyc.ktgood

import com.yyc.baselib.utils.L
import com.yyc.ktgood.tow.TwoContract
import com.yyc.ktgood.tow.TwoPresenter
import com.yyc.wclib.mvp.MvpBaseActivity

class TwoActivity : MvpBaseActivity<TwoContract.TwoView,TwoPresenter>(),TwoContract.TwoView {

    override fun login() {
        L.e("大哥好")

    }

    override fun loadDataError(error: String?) {
    }

    override fun loadDataSuccess(obj: Any?) {
    }

    override fun layoutId(): Int {
        return R.layout.activity_two
    }

    override fun initView() {
        L.e("11--" + mPresenter)
        mPresenter?.login()
    }


}
