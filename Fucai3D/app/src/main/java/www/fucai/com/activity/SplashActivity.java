package www.fucai.com.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import www.fucai.com.BaseActivity;
import www.fucai.com.R;
import www.fucai.com.bean.ApiUrl;
import www.fucai.com.constants.Constants;

public class SplashActivity extends BaseActivity {
    private static final int TIME = 1000;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Bmob.initialize(this, Constants.BMOB_APP_ID);
        //updateBmob();
        //getFuData(Constants.FU_CAI_APP_ID);
        getYiData(Constants.YI_YUAN_GOU_APP_ID);
    }

    private String urlPath = "http://www.thduobao.com/?cpa=baidu";
    private void getFuData(String objectId) {
        BmobQuery<ApiUrl> bmobQuery = new BmobQuery<ApiUrl>();
        bmobQuery.getObject(objectId, new QueryListener<ApiUrl>() {
            @Override
            public void done(ApiUrl apiUrl, BmobException e) {
                if (apiUrl != null) {
                    if (TextUtils.isEmpty(apiUrl.getHttpUrl())) {
                        handler.postDelayed(mainRunable, TIME);
                    } else {
                        urlPath = apiUrl.getHttpUrl();
                        if (urlPath.indexOf("http") != -1) {
                            handler.postDelayed(webRunable, TIME);
                        } else {
                            handler.postDelayed(mainRunable, TIME);
                        }
                    }
                }
            }
        });
    }

    private void getYiData(String objectId) {
        BmobQuery<ApiUrl> bmobQuery = new BmobQuery<ApiUrl>();
        bmobQuery.getObject(objectId, new QueryListener<ApiUrl>() {
            @Override
            public void done(ApiUrl apiUrl, BmobException e) {
                if (apiUrl != null) {
                    if (!TextUtils.isEmpty(apiUrl.getHttpUrl())) {
                        if (apiUrl.getHttpUrl().indexOf("http") != -1) {
                            urlPath = apiUrl.getHttpUrl();
                        }
                    }
                }
                handler.postDelayed(webRunable, TIME);
            }
        });
    }



    private void updateBmob(){
        ApiUrl apiUrl = new ApiUrl();
        apiUrl.setHttpUrl("");
        apiUrl.setApp_name("一元购物");
        apiUrl.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    toast("添加数据成功，返回objectId为："+objectId);
                }else{
                    toast("创建数据失败：" + e.getMessage());
                }
            }
        });
    }


    Runnable mainRunable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    Runnable webRunable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, WebActivity.class);
            intent.putExtra("url", urlPath);
            startActivity(intent);
            finish();
        }
    };

    /**
     * 吐司
     *
     * @param message
     */
    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        System.out.print("创建数据失败：------------------------------------->:" + message);
    }

}
