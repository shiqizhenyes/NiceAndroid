package me.nice.category;

import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import me.nice.base.mvp.BaseMvpAppCompatActivity;

public class WebViewActivity extends BaseMvpAppCompatActivity<WebViewPresenterImpl>
        implements Contract.WebViewView, View.OnClickListener {

    private WebView wvWebView;
    private ConstraintLayout constraintLayout;
    private Button addWebView;
    private Button removeWebView;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    public void initView() {

        constraintLayout = findViewById(me.nice.ui.R.id.constraintLayout);
//        addWebView = findViewById(me.nice.ui.R.id.addWebView);
//        removeWebView = findViewById(me.nice.ui.R.id.removeWebView);

    }

    @Override
    public WebViewPresenterImpl initPresenter() {
        return new WebViewPresenterImpl();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(WebViewActivity.class.getSimpleName(),"onResume");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(WebViewActivity.class.getSimpleName(),"onRestart");

    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(WebViewActivity.class.getSimpleName(),"onStop");
        wvWebView.destroy();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(WebViewActivity.class.getSimpleName(),"onDestroy");

//        wvWebView.destroy();
    }

    @Override
    public void onClick(View v) {

        int i = v.getId();

//        if (i == me.nice.ui.R.id.addWebView) {
            wvWebView = new WebView(this);
            wvWebView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
//            ConstraintSet constraintSet = new ConstraintSet();
//            constraintSet.clone(constraintLayout);
//
//            constraintSet.constrainWidth(wvWebView.getId(), ConstraintLayout.LayoutParams.MATCH_PARENT);
//            constraintSet.constrainHeight(wvWebView.getId(), ConstraintLayout.LayoutParams.MATCH_PARENT);
//
//            constraintSet.connect(wvWebView.getId(), ConstraintSet.END,  ConstraintSet.PARENT_ID,ConstraintSet.END);
//            constraintSet.connect(wvWebView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID,ConstraintSet.START);
//            constraintSet.connect(wvWebView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID,ConstraintSet.TOP);

            //这个按钮距离底部的margin值为1000
//            constraintSet.connect(wvWebView.getId(),ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM,1000);

            constraintLayout.addView(wvWebView);

//            constraintSet.applyTo(constraintLayout);

            WebSettings webSettings = wvWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            wvWebView.addJavascriptInterface(new Login(), "userLogin");
            wvWebView.loadUrl("file:////android_asset/java_js.html");
//        } else if (i == me.nice.ui.R.id.removeWebView) {
//
//
//        }

    }


    public class Login {

        @JavascriptInterface
        public void loginCheck(String account, String password) {

//            Log.d(WebViewActivity.class.getSimpleName(), "account " + account + " password " + password);

            if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {

                Toast.makeText(getBaseContext(),"账户和密码不能为空", Toast.LENGTH_LONG).show();

            }else if (account.equals("test") && password.equals("test")){

                Toast.makeText(getBaseContext(),"登录成功", Toast.LENGTH_LONG).show();

            }else {

                Toast.makeText(getBaseContext(),"登录失败", Toast.LENGTH_LONG).show();

            }

        }

    }



}
