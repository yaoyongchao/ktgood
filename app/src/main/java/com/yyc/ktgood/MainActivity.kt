package com.yyc.ktgood

import android.content.Intent
import com.yyc.baselib.http.BaseObserver
import com.yyc.baselib.http.ServiceFactory
import com.yyc.baselib.utils.L
import com.yyc.wclib.base.BaseActivity
import com.yyc.wclib.http.User
import com.yyc.wclib.utils.MyRxScheduler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initView() {

        btn1.setOnClickListener {
            startActivity(Intent(this,TwoActivity::class.java))
        }

        btn2.setOnClickListener {
            ServiceFactory.getService()
                    .login1()
                    .compose(MyRxScheduler.ioMain())
                    .subscribe(object : BaseObserver<User>(){
                        override fun onSuccess(t: User?) {
                            L.e("name: --- " + t!!.name + t!!.age)
                        }

                        override fun onFail(msg: String) {
                            super.onFail(msg)
                            L.e("$msg")
                        }
                    })
        }

    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }*/
}
