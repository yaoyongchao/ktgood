package com.yyc.baselib.utils

import android.annotation.SuppressLint
import android.widget.Toast
import com.yyc.wclib.BaseApplication

/**
 * Author: Austin
 * Date: 2018/10/9
 * Description:
 */
class ToastUtil {
    companion object {
        @SuppressLint("StaticFieldLeak")
        private var mContext = BaseApplication.appContext
        public fun show(msg: String) {
            Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show()
        }

        public fun showLong(msg: String) {
            Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show()
        }
    }
}