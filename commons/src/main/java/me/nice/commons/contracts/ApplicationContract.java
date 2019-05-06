package me.nice.commons.contracts;

import android.app.Application;
import android.util.Log;

import me.nice.base.BaseAbstractApplication;

public class ApplicationContract {

    private final static String Category = "me.nice.category.Category";

    private final static String[] Applications = {Category};

    public static void initApplication(Application application) {

        for (String s: Applications) {
            try {
                Class clazz = Class.forName(s);
                clazz.newInstance();
                ((BaseAbstractApplication)(clazz.newInstance())).initModelApplication(application);
            } catch (ClassNotFoundException e) {
                Log.d(ApplicationContract.class.getSimpleName(), "1");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                Log.d(ApplicationContract.class.getSimpleName(), "2");
                e.printStackTrace();
            } catch (InstantiationException e) {
                Log.d(ApplicationContract.class.getSimpleName(), "3");
                e.printStackTrace();
            }
        }

    }

}
