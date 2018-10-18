package com.yyc.ktgood.tow

import android.util.Log
import com.yyc.wclib.http.User
import com.yyc.wclib.mvp.MVPListener

class TwoPresenter: TwoContract.TwoPresenter<TwoModel>() {
    override fun login() {
        Log.e("aa","222model: ")
        mModel?.getData(object : MVPListener<User> {
            override fun onSuccess(data: User) {
                view.login()

            }

            override fun onError(error: String) {

            }
        })
    }

}
