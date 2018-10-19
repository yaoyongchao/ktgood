package com.yyc.ktgood

import android.content.Intent
import android.util.Log
import com.yyc.baselib.http.ServiceFactory
import com.yyc.baselib.utils.L
import com.yyc.ktgood.entity.User
import com.yyc.wclib.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : BaseActivity() {
    var i = 1
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initView() {
        btn_in.setOnClickListener {
            var user: User = User()
            user.age = i
            user.name = "zs$i"
            i++
            WcApplication.mDaoSession.userDao.insert(user)
        }

        btn_check.setOnClickListener {
            var list:List<User> = WcApplication.mDaoSession.userDao.loadAll()

            for (u in list) L.e("user: name- ${u.name} --- age- ${u.age} --- id: ${u.id}")

        }

        btn_router.setOnClickListener {
            startActivity(Intent(this,ForeActivity::class.java))
        }

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
