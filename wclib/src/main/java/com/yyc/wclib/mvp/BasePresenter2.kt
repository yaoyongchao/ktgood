package com.yyc.wclib.mvp

import com.yyc.baselib.mvp.BaseModel
import java.lang.ref.WeakReference

abstract class BasePresenter2<V: BaseView, M: BaseModel> {
    var view: WeakReference<V>? = null

    fun bindView(view: V) {
        this.view = WeakReference(view)
    }

    fun isBind(): Boolean {
        return view != null && view!!.get() != null
    }

    fun unBindView() {
        if (isBind()) {
            view!!.clear()
            view = null
        }
    }

    fun obtainView(): V? {
        return if (isBind()) view!!.get() else null
    }
}