package com.yyc.ktgood.tow

import com.yyc.baselib.utils.L
import com.yyc.wclib.http.User
import com.yyc.wclib.mvp.MVPListener

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

        L.e("TwoPresenter  --- model: $mModel")
        mModel?.getData(object : MVPListener<User>{
            override fun onSuccess(data: User?) {
                L.e("TwoPresenter--1111")
                obtainView()?.login()
            }

            override fun onError(error: String?) {
                L.e("TwoPresenter----2222")
            }
        })
        /*mModel?.getData(object : MVPListener<User> {
            override fun onSuccess(data: User) {
                view?.login()

            }

            override fun onError(error: String) {

            }
        })*/
    }

}
