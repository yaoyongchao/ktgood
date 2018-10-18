package com.yyc.ktgood

import android.util.Log
import com.yyc.ktgood.tow.TwoContract
import com.yyc.ktgood.tow.TwoPresenter
import com.yyc.wclib.mvp.MvpBaseActivity

class TwoActivity : MvpBaseActivity<TwoPresenter>(),TwoContract.TwoView {
    override fun login() {

    }

    override fun loadDataError(error: String?) {
    }

    override fun loadDataSuccess(obj: Any?) {
    }

    override fun layoutId(): Int {
        return R.layout.activity_two
    }

    override fun initView() {
        Log.e("aa","11--" + mPresenter)
        mPresenter?.login()
    }


}
