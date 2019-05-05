package me.nice.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class BaseAbstractApplication<F extends BaseFragment> extends Application implements Application.ActivityLifecycleCallbacks {

    private Stack<Activity> activities = new Stack<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        activities.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        activities.remove(activity);
    }

    public abstract void initModelApplication(Application application);

}
