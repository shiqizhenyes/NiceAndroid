package me.nice.android;

import android.app.Application;
import android.util.Log;
import me.nice.base.BaseAbstractApplication;
import me.nice.commons.contracts.ApplicationContract;


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
        ApplicationContract.initApplication(application);
    }

    @Override
    public void initModelApplicationData(Application application) {
        ApplicationContract.initApplication(application);
    }

}
