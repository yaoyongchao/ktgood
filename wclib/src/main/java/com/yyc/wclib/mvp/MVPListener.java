package com.yyc.wclib.mvp;

/**
 * Author: Austin
 * Time: 2018/7/18
 * Description: Model层数据处理后的回调接口。
 */
public interface MVPListener<T> {
    void onSuccess(T data);

    void onError(String error);
}
