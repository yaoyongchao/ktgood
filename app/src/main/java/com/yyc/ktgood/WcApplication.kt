package com.yyc.ktgood

import android.database.sqlite.SQLiteDatabase
import com.yyc.ktgood.greendao.DaoMaster
import com.yyc.ktgood.greendao.DaoSession
import com.yyc.wclib.BaseApplication

class WcApplication: BaseApplication() {
//    const val 可见性为public final static，可以直接访问。
//    val 可见性为private final static，并且val 会生成方法getNormalObject() ，通过方法调用访问。
    val DB_NAME = "yyc.db"

    companion object {
        lateinit var mDaoSession: DaoSession
    }

    override fun initViews() {
        super.initViews()
        initGreenDao()
    }

    private fun initGreenDao() {
        var helper: DaoMaster.DevOpenHelper = DaoMaster.DevOpenHelper(this,DB_NAME)
        var db:SQLiteDatabase = helper.writableDatabase
        var daoMaster: DaoMaster = DaoMaster(db)
        mDaoSession = daoMaster.newSession()
    }


}