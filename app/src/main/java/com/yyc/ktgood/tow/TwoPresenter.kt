package com.yyc.ktgood.tow

import android.util.Log

class TwoPresenter: TwoContract.TwoPresenter<TwoModel>() {
    override fun login() {
        Log.e("aa","222model: ")
        mModel?.getData()
    }

}
