package me.nice.ui;

import android.os.Handler;
import android.widget.ProgressBar;

import java.util.logging.LogRecord;

import me.nice.base.BaseAppCompatActivity;

public class ProgressBarActivity extends BaseAppCompatActivity {

    private ProgressBar progressBar;

    Handler handler = new Handler();

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_progress_bar;
    }

    @Override
    public void initView() {

        progressBar = findViewById(R.id.progressBar);

        new Thread(new Runnable() {

            int i = 0;

            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        i += 10;
                        progressBar.setProgress(i);

                        handler.postDelayed(this,1000);

                    }
                });


            }
        }).start();

    }
}
