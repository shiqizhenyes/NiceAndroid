package me.nice.android;

import android.app.Application;
import android.util.Log;

//import com.apt.ApplicationConfigs;


import me.nice.annotation.apt.ApplicationConfig;
import me.nice.base.BaseAbstractApplication;

//@ApplicationConfig
public class Nice extends BaseAbstractApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initModelApplication(this);
    }

    @Override
    public void initModelApplication(Application application) {
        Log.d(Nice.class.getSimpleName(), "执行initModelApplication");
        try {
            Class clazz = Class.forName("me.nice.category.Category");
            clazz.newInstance();
//            baseAbstractApplication.initModelApplication(this);
        } catch (ClassNotFoundException e) {
            Log.d(Nice.class.getSimpleName(), "1");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            Log.d(Nice.class.getSimpleName(), "2");
            e.printStackTrace();
        } catch (InstantiationException e) {
            Log.d(Nice.class.getSimpleName(), "3");
            e.printStackTrace();
        }
    }

}
