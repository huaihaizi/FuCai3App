package www.fucai.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.widget.Toast;

import com.github.lzyzsd.jsbridge.BridgeWebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.fucai.com.R;

public class WebActivity extends Activity {
    @BindView(R.id.webview)
    BridgeWebView webView;//网页加载区
    WebSettings webSettings;
    String urlPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        initWebSettings();
        if (!TextUtils.isEmpty(intent.getStringExtra("url"))) {
            if (!TextUtils.isEmpty(intent.getStringExtra("url"))) {
                urlPath = intent.getStringExtra("url");
                if (!TextUtils.isEmpty(urlPath)) {
                    webView.loadUrl(urlPath);
                }
            }
        }
    }

    /**
     * 初始化WebSettings是设置
     */
    @JavascriptInterface
    private void initWebSettings() {
        webSettings = webView.getSettings();
        webView.setBackgroundColor(Color.parseColor("#f3f3f3"));
        webSettings.setTextZoom(100);//设置字体缩放比例
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptEnabled(true);//启用js
        webSettings.setBlockNetworkImage(false);//解决图片不显示
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        int screenDensity = getResources().getDisplayMetrics().densityDpi;
        WebSettings.ZoomDensity zoomDensity = WebSettings.ZoomDensity.MEDIUM;
        switch (screenDensity) {
            case DisplayMetrics.DENSITY_LOW:
                zoomDensity = WebSettings.ZoomDensity.CLOSE;
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                zoomDensity = WebSettings.ZoomDensity.MEDIUM;
                break;
            case DisplayMetrics.DENSITY_HIGH:
                zoomDensity = WebSettings.ZoomDensity.FAR;
                break;
        }
        webSettings.setDefaultZoom(zoomDensity);// 按照屏幕密度比例缩放
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);// 支持内容重新布局
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);// 适应屏幕

    }

    private boolean isFirst = true;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isFirst) {
                Toast.makeText(WebActivity.this, "再按一次退出应用", Toast.LENGTH_LONG).show();
                isFirst = !isFirst;
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
