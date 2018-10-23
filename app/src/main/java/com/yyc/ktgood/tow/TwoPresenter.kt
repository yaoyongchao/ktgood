package com.yyc.ktgood.tow

import android.util.Log

class TwoPresenter: TwoContract.TwoPresenter<TwoModel>() {
    override fun login() {
        /*Log.e("aa","222model: ")
        mModel?.getData(object : MVPListener<User> {
            override fun onSuccess(data: User) {
                view?.login()

            }

            override fun onError(error: String) {

            }
        })*/

        Log.e("aa", "Presenter")
    }

}
