package com.yyc.ktgood.tow

import com.yyc.baselib.mvp.BaseModel
import com.yyc.wclib.mvp.BasePresenter
import com.yyc.wclib.mvp.BaseView

interface TwoContract {
    interface TwoView: BaseView {
        fun login()
    }
    abstract class TwoPresenter<M: BaseModel>(): BasePresenter<M, TwoView>() {
        abstract fun login()
    }
    interface TwoModel: BaseModel {
        fun getData()
    }

 }