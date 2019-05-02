package me.nice.category;

import me.nice.base.mvp.BasePresenter;
import me.nice.base.mvp.BaseView;

public interface Contract {


    interface WebViewPresenter extends BasePresenter<WebViewView> {

    }

    interface WebViewView extends BaseView {}

}
