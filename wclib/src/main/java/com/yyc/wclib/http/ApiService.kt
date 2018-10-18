package com.yyc.baselib.http

import com.yyc.baselib.http.entity.BaseEntity
import com.yyc.wclib.http.User
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * Author: Austin
 * Date: 2018/10/9
 * Description:
 */

interface ApiService {
//    @GET("login")
//    Call<You> login();

    /*@GET("login1")
    fun login1(): Observable<BaseEntity<User>>*/


    @GET("login1")
    fun login1(): Observable<BaseEntity<User>>

    @GET("login1")
    fun login2(): Observable<ResponseBody>
}