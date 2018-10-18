package com.yyc.wclib

import android.app.Application
import android.content.Context
import com.yyc.baselib.utils.L
import okhttp3.internal.Internal.instance

/**
 * Author: Austin
 * Date: 2018/10/8
 * Description:
 */
class BaseApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        initViews()
    }

    private fun initViews() {
        appContext = applicationContext
//        instance = this
        L.initLogger()
    }

    companion object {
//        lateinit var instance: BaseApplication
        lateinit var appContext: Context
    }

}