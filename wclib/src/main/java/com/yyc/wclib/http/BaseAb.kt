package com.yyc.baselib.http

import com.yyc.baselib.http.entity.BaseEntity

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Author: Austin
 * Date: 2018/10/9
 * Description:
 */
open class BaseAb<T> : Subscriber<BaseEntity<T>> {
    override fun onSubscribe(s: Subscription) {

    }

    override fun onNext(tBaseEntity: BaseEntity<T>) {

    }

    override fun onError(t: Throwable) {

    }

    override fun onComplete() {

    }
}
