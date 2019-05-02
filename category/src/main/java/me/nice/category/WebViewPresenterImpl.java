package me.nice.category;

import android.util.Log;

import me.nice.annotation.apt.InstanceFactory;
import me.nice.base.mvp.BasePresenterImpl;
import me.nice.base.mvp.BaseView;

@InstanceFactory
public class WebViewPresenterImpl extends BasePresenterImpl<Contract.WebViewView> implements Contract.WebViewPresenter {

    public WebViewPresenterImpl() {
        Log.d(WebViewPresenterImpl.class.getSimpleName(), "初始化");
    }

}
