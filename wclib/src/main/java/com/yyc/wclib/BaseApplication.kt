package com.yyc.wclib

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.yyc.baselib.utils.L

/**
 * Author: Austin
 * Date: 2018/10/8
 * Description:
 */
open class BaseApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        initViews()
    }

    open fun initViews() {
        appContext = applicationContext
//        instance = this
        L.initLogger()

        //ARouter
        if (BuildConfig.DEBUG) {
            ARouter.openLog()//打开日志
            ARouter.openDebug()//打开调式模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
    }



    companion object {
//        lateinit var instance: BaseApplication
        lateinit var appContext: Context
    }

}