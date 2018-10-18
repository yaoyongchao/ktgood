package com.yyc.ktgood

import android.content.Intent
import android.util.Log
import com.yyc.baselib.http.BaseObserver
import com.yyc.baselib.http.ServiceFactory
import com.yyc.baselib.utils.L
import com.yyc.wclib.base.BaseActivity
import com.yyc.wclib.http.User
import com.yyc.wclib.utils.MyRxScheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initView() {
        Log.e("aa","你好")

        L.e("L---ni")

        btn1.setOnClickListener {
            startActivity(Intent(this,TwoActivity::class.java))
        }

        btn2.setOnClickListener {

            ServiceFactory.getService()
                    .login1()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            {
                                L.e("onnext")
                                Log.e("aa","noNext")

                            },
                            {
                                L.e("eoor")
                                Log.e("aa","erroor")
                            },
                            {
                                L.e("onComplete")
                                Log.e("aa","onComplete")
                            }
                    )



            /*ServiceFactory.getService()
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
                    })*/
        }

    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }*/
}
