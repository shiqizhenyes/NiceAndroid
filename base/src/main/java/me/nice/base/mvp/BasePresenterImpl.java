package me.nice.base.mvp;

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {

    private V mView;

    @Override
    public V getView() {
        return mView;
    }

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public void onDetached() {

    }

}
