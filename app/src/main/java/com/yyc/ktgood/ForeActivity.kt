package com.yyc.ktgood

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_fore.*

/**
 * @Author: Austin
 * @Date: 2018/10/18
 * @Description: ARout 跳转测试
 */
@Route(path="/test/ForeActivity")
class ForeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fore)
        btnme.setOnClickListener {
            ARouter.getInstance().build("/test/MeActivity").navigation()
        }
    }
}
