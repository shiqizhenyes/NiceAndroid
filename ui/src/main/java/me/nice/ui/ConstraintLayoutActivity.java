package me.nice.ui;


import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;

import me.nice.base.BaseAppCompatActivity;

public class ConstraintLayoutActivity extends BaseAppCompatActivity implements View.OnClickListener {

    private ConstraintLayout constraintLayout;
    private Button addView;
    private Button removeView;


    @Override
    public int getRootLayoutId() {
        return R.layout.activity_constraint_layout;
    }

    @Override
    public void initView() {
        constraintLayout = findViewById(R.id.constraintLayout);
        addView = findViewById(R.id.addView);
        removeView = findViewById(R.id.removeView);
        addView.setOnClickListener(this);
        removeView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        int i = v.getId();
        if (i == R.id.addView) {


        } else if (i == R.id.removeView) {

        }

    }

}
