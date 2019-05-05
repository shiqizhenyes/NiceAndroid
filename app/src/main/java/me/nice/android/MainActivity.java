package me.nice.android;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.nice.base.BaseFragment;
import me.nice.base.BaseFragmentAdapter;
import me.nice.base.BaseFragmentStateAdapter;
import me.nice.base.IFragmentsImpl;
import me.nice.base.mvp.BaseMvpAppCompatActivity;


public class MainActivity extends BaseMvpAppCompatActivity<Contract.MainPresenter, Contract.MainView>
        implements Contract.MainView {

    private static String tag = MainActivity.class.getSimpleName();
    private ViewPager appMainViewPager;
    private List<BaseFragment> baseFragments = new ArrayList<>();

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
        appMainViewPager = findViewById(R.id.appMainViewPager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        baseFragments = IFragmentsImpl.getInstance().getFragments();
        Log.d(tag,"baseFragments "+ String.valueOf(baseFragments.size()));
        BaseFragmentAdapter fragmentAdapter = new BaseFragmentAdapter(fragmentManager, baseFragments);
        appMainViewPager.setAdapter(fragmentAdapter);
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
