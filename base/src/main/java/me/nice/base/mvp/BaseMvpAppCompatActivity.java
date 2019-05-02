package me.nice.base.mvp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import me.nice.base.BaseAppCompatActivity;

public abstract class BaseMvpAppCompatActivity<P extends BasePresenter<V>, V extends BaseView> extends BaseAppCompatActivity implements BaseView {

    public P presenter;

    @Override
    public int getRootLayoutId() {
        return 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initView() {
        presenter = initPresenter();
        presenter.attachView((V) this);
    }

    public abstract P initPresenter();

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
