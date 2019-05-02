package me.nice.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public abstract class BaseAppCompatActivity extends AppCompatActivity {

    private int statusBarColor = R.color.design_default_color_primary;

    private boolean statusBarIsHide = false;

    private int statusBarFontColor = BLACK;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootLayoutId());
        initView();
        initStatusBar();
    }

    public abstract int getRootLayoutId();

    public abstract void initView();

    public void setStatusBarColor(int statusBarColor) {
        this.statusBarColor = statusBarColor;
    }

    public void setStatusBarIsHide(boolean statusBarIsHide) {
        this.statusBarIsHide = statusBarIsHide;
    }

    public void setStatusBarFontColor(int statusBarFontColor) {
        this.statusBarFontColor = statusBarFontColor;
    }

    private Integer getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (statusBarFontColor == WHITE) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }else {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }
        if (statusBarIsHide) {
            getWindow().getDecorView().setPadding(0,0,0,0);
        }else {
            getWindow().getDecorView().setPadding(0, getStatusBarHeight(),0,0);
        }
        getWindow().getDecorView()
                .setBackgroundColor(ContextCompat.getColor(getBaseContext(), statusBarColor));
    }

}
