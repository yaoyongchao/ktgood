/*
package com.yyc.wclib.mvp;

import android.os.Bundle;

import com.yyc.wclib.base.BaseActivity;
import com.yyc.wclib.utils.CreatUtilOne;

import org.jetbrains.annotations.Nullable;

public abstract class MvpBaseActivity<P extends BasePresenter> extends BaseActivity{
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = CreatUtilOne.getT(this,0);
        mPresenter.attachView(this);
        super.onCreate(savedInstanceState);

    }

*/
/*
    @Override
    public void initView() {

    }
*//*


    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dettachView();
    }
}
*/
