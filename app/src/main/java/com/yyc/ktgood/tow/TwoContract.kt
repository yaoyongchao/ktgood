package com.yyc.ktgood.tow

import com.yyc.baselib.mvp.BaseModel
import com.yyc.wclib.http.User
import com.yyc.wclib.mvp.BasePresenter
import com.yyc.wclib.mvp.BaseView
import com.yyc.wclib.mvp.MVPListener

interface TwoContract {
    interface TwoView: BaseView {
        fun login()
    }
    abstract class TwoPresenter<M: BaseModel>(): BasePresenter<M, TwoView>() {
        abstract fun login()
    }
    interface TwoModel: BaseModel {
        fun getData(listener: MVPListener<User>)
    }

 }