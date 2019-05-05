package me.nice.category;

import android.app.Application;
import android.util.Log;

import me.nice.annotation.apt.ApplicationConfig;
import me.nice.base.BaseAbstractApplication;
import me.nice.base.IFragmentsImpl;

//@ApplicationConfig
public class Category extends BaseAbstractApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(Category.class.getSimpleName(),"添加CategoryFragment");

        initModelApplication(this);
        IFragmentsImpl.getInstance().addFragment(CategoryFragment.newInstance("",""));
        Log.d(Category.class.getSimpleName(),"添加CategoryFragment");
    }

    @Override
    public void initModelApplication(Application application) {

        Log.d(Category.class.getSimpleName(),"添加CategoryFragment");

    }

}
