package me.nice.base.mvp;

public interface BasePresenter<V extends BaseView> {

    V getView();

    void attachView(V view);

    void detachView();

    void onDetached();

}
