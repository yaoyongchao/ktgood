package com.yyc.baselib.http


import com.yyc.baselib.utils.L
import com.yyc.wclib.BuildConfig

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.http.HttpHeaders

/**
 * Author: Austin
 * Date: 2018/10/10
 * Description: 拦截器
 */
class LoggerInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        // 拦截请求，获取到该次请求的request
        val request = chain.request()
        // 执行本次网络请求操作，返回response信息
        val response = chain.proceed(request)
        if (BuildConfig.DEBUG) {
            for (key in request.headers().toMultimap().keys) {
                L.e("header: {" + key + " : " + request.headers().toMultimap()[key] + "}")
            }
            L.e("url: " + request.url().uri().toString())
            val responseBody = response.body()

            if (HttpHeaders.hasBody(response) && responseBody != null) {
                val bufferedReader = BufferedReader(InputStreamReader(responseBody.byteStream(), "utf-8"))
                var result: String = bufferedReader.readLine()

                while (result != null) {
                    L.e("response: $result")
                }
                // 测试代码
                responseBody.string()
            }
        }
        // 注意，这样写，等于重新创建Request，获取新的Response，避免在执行以上代码时，
        // 调用了responseBody.string()而不能在返回体中再次调用。
        return response.newBuilder().build()
    }

}