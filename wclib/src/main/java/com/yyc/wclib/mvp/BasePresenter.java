package com.yyc.wclib.mvp;

import com.yyc.baselib.mvp.BaseModel;
import com.yyc.wclib.utils.CreatUtilOne;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends BaseModel,V /*extends BaseView*/> {
    public M mModel;
    private V mView;
    private WeakReference<V> mViewRef;
    public boolean isAttach;

    /*public void attachModelView(*//*M pModel,*//* V pView) {
//        this.model = pModel;
        mViewRef = new WeakReference<>(pView);
    }*/
    /**
     * 绑定的方法
     * 在onCreate()中调用
     * @param pView
     */
    public void attachView(V pView) {
        mViewRef = new WeakReference<>(pView);
        mModel = CreatUtilOne.getT(this,0);
//        Log.e("aa","BasePresenter: $ mModel--" + mModel);
    }

    public boolean isAttach() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public V getView() {
        if (isAttach()) {
            return mViewRef.get();
        } else {
            return null;
        }
    }

    /**
     * 解绑
     * 在onDestroy方法中调用，防止内存泄漏
     */
    public void dettachView() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
