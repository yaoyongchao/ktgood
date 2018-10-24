package com.yyc.ktgood.tow

import com.yyc.baselib.http.BaseObserver
import com.yyc.baselib.http.ServiceFactory
import com.yyc.baselib.utils.L
import com.yyc.wclib.http.User
import com.yyc.wclib.mvp.MVPListener
import com.yyc.wclib.utils.MyRxScheduler

class TwoModel: TwoContract.TwoModel {
    public override fun getData(listener: MVPListener<User>) {
        ServiceFactory.getService()
                .login1()
                .compose(MyRxScheduler.ioMain())
                .subscribe(object : BaseObserver<User>(){
                    override fun onSuccess(t: User?) {
                        L.e("name: --- " + t!!.name + t!!.age)
                        listener.onSuccess(t)
                    }
                    override fun onFail(msg: String) {
                        super.onFail(msg)
                        L.e("$msg")
                    }
                })
    }

    /*override fun getData() {
        Log.e("aa","３３TwoModel")

       *//* ServiceFactory.getService().login2()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        {
                            L.e("onnext")

                        },
                        {
                            L.e("eoor")
                        },
                        {
                            L.e("onComplete")
                        }
                )*//*



        *//*ServiceFactory.getService().login1()
//                    .map(HttpResultFunc<User>())
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .compose(SchedulerTransformer.applySchedulers())
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
*//*



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
    }*/

}