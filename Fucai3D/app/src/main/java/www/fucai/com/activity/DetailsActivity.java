package www.fucai.com.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import www.fucai.com.BaseActivity;
import www.fucai.com.R;
import www.fucai.com.adapter.ListViewAdapter;
import www.fucai.com.bean.ApiUrl;
import www.fucai.com.bean.BaseUrlInfo;
import www.fucai.com.bean.DataBean;
import www.fucai.com.constants.Constants;
import www.fucai.com.utils.GsonUtils;
import www.fucai.com.utils.HttpCallUtils;

/**
 * 数据详情页面
 */
public class DetailsActivity extends BaseActivity {
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.title_back)
    ImageView title_back;
    @BindView(R.id.webview)
    WebView webView;//网页加载区
    WebSettings webSettings;
    String url = "";
    String urlPath = "";
    String name = "";
    String objectId = "";
    private ListViewAdapter adapter;
    private List<DataBean> dataBeanInfoList;
    Call call = null;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Bmob.initialize(this, "0160061a950cd78c2f14730f3a7d4544");
        dataBeanInfoList = new ArrayList<DataBean>();
        adapter = new ListViewAdapter(this, dataBeanInfoList);
        listView.setAdapter(adapter);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        urlPath = intent.getStringExtra("url");
        initWebSettings();
        if (!TextUtils.isEmpty(name)) {
            title_text.setText(name + getResources().getString(R.string.result_open));
        }
        if (!TextUtils.isEmpty(urlPath)) {
            url = "http://f.apiplus.net/" + urlPath + "-50.json";
            getHttpData(url);
        }
    }



    private void getHttpData(String urlPath) {
        call = HttpCallUtils.sendGet(urlPath);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                message =  "数据请求失败";
                handler.post(erroeRunnable);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response==null){
                    return;
                }
                if(response.body()==null){
                    return;
                }
                if (TextUtils.isEmpty(response.body().toString())) {
                    return;
                }
                String responseStr = response.body().string();
                BaseUrlInfo urlInfo = null;
                try {
                    urlInfo = GsonUtils.convertObj(responseStr, BaseUrlInfo.class);
                    if (urlInfo != null) {
                        if (urlInfo.getData() != null && !urlInfo.getData().isEmpty()) {
                            dataBeanInfoList.addAll(urlInfo.getData());
                            handler.post(runnable);
                        }
                    }
                } catch (Exception e) {
                    message =  "刷新频率过快，每次间隔不得少于3秒";
                    handler.post(erroeRunnable);
                    e.printStackTrace();
                }
            }
        });

    }


    @OnClick({R.id.title_back})
    public void onClickView(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                finish();
                break;
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            adapter.notifyDataSetChanged();
        }
    };
    private String message = "";
    Runnable erroeRunnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(DetailsActivity.this, message, Toast.LENGTH_LONG).show();
        }
    };



    /**
     * 初始化WebSettings是设置
     */
    @JavascriptInterface
    private void initWebSettings() {
        webSettings = webView.getSettings();
        webView.setBackgroundColor(Color.parseColor("#f3f3f3"));
        webSettings.setTextZoom(100);//设置字体缩放比例
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setBlockNetworkImage(true);// 图片不加载，网页加载完毕在onPageFinished中打开

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


}
