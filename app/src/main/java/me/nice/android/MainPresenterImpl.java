package me.nice.android;

import android.util.Log;

import me.nice.base.mvp.BasePresenterImpl;
import me.nice.base.mvp.BaseView;

public class MainPresenterImpl extends BasePresenterImpl<Contract.MainView>
        implements Contract.MainPresenter {

    MainPresenterImpl() {
        Log.d(MainPresenterImpl.class.getSimpleName(),"");
    }

    @Override
    public void test() {
        Log.d(MainPresenterImpl.class.getSimpleName(),"测试");
        getView().testView();
    }

}
