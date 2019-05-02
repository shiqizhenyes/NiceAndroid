package me.nice.android;

import android.util.Log;

import me.nice.base.mvp.BasePresenter;
import me.nice.base.mvp.BasePresenterImpl;
import me.nice.base.mvp.BaseView;

public interface Contract {


    interface MainPresenter extends BasePresenter<MainView> {
        void test();
    }

    interface MainView extends BaseView {

        void testView();

    }


}
