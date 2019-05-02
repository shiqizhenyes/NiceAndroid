package me.nice.android;

import android.util.Log;

import me.nice.base.mvp.BaseMvpAppCompatActivity;


public class MainActivity extends BaseMvpAppCompatActivity<Contract.MainPresenter, Contract.MainView>
        implements Contract.MainView {

    private static String tag = MainActivity.class.getSimpleName();

    @Override
    public int getRootLayoutId() {
//        List<Integer> integers = new ArrayList<>();
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();
        setStatusBarColor(R.color.md_white);
        setStatusBarIsHide(false);
        presenter.test();
        presenter.test();
        Log.d(tag, "initView");
    }

    @Override
    public Contract.MainPresenter initPresenter() {
        Log.d(tag, "initPresenter");
        presenter = new MainPresenterImpl();
        return presenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Intent intent = new Intent(this, ProgressBarActivity.class);
//        startActivity(intent);
    }

    @Override
    public void testView() {
        Log.d(tag, "testView");
    }
}
