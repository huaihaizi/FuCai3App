package www.fucai.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.panxw.android.imageindicator.AutoPlayManager;
import com.panxw.android.imageindicator.ImageIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import www.fucai.com.BaseActivity;
import www.fucai.com.R;
import www.fucai.com.bean.ApiUrl;
import www.fucai.com.constants.Constants;

/**
 * className: MainActivity
 * Description: 主页面展示Activity
 * author huaixiaoyao
 * date 2017/6/15
 */
public class MainActivity extends BaseActivity {
    ImageIndicatorView imageIndicatorView;
    @BindView(R.id.shuangseqiu)
    TextView shuangseqiu;
    @BindView(R.id.daletou)
    TextView daletou;
    @BindView(R.id.fucai3d)
    TextView fucai3d;
    @BindView(R.id.pailei3)
    TextView pailei3;
    @BindView(R.id.pailie5)
    TextView pailie5;
    @BindView(R.id.shishicai)
    TextView shishicai;
    @BindView(R.id.qixingcai)
    TextView qixingcai;
    @BindView(R.id.qilecai)
    TextView qilecai;
    @BindView(R.id.xuan115)
    TextView xuan115;
    @BindView(R.id.kaile3)
    TextView kaile3;
    @BindView(R.id.kaile8)
    TextView kaile8;
    @BindView(R.id.kaile10)
    TextView kaile10;
    @BindView(R.id.title_back)
    ImageView title_back;

    final Integer[] resArray = new Integer[]{R.drawable.lunbo_1, R.drawable.lunbo_7, R.drawable.lunbo_8};
    private String urlType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        title_back.setVisibility(View.GONE);
        imageIndicatorView = (ImageIndicatorView) findViewById(R.id.indicate_view);
        imageIndicatorView.setupLayoutByDrawable(resArray);
        imageIndicatorView.setIndicateStyle(ImageIndicatorView.INDICATE_USERGUIDE_STYLE);
        imageIndicatorView.show();
        AutoPlayManager autoBrocastManager = new AutoPlayManager(imageIndicatorView);
        autoBrocastManager.setBroadcastEnable(true);
        autoBrocastManager.setBroadCastTimes(5);//loop times
        autoBrocastManager.setBroadcastTimeIntevel(2 * 1000, 3 * 1000);//set first play time and interval
        autoBrocastManager.loop();
    }

    private String name = "";

    @OnClick({R.id.shuangseqiu, R.id.daletou, R.id.fucai3d, R.id.pailei3, R.id.pailie5, R.id.shishicai, R.id.qixingcai, R.id.qilecai, R.id.xuan115, R.id.kaile3, R.id.kaile8, R.id.kaile10})
    public void onClickView(View v) {
        switch (v.getId()) {
            case R.id.shuangseqiu:
                name = getResources().getString(R.string.shuangseqiu);
                goToDetails(Constants.shuangseqiu, name);
                break;
            case R.id.daletou:
                name = getResources().getString(R.string.daletou);
                goToDetails(Constants.daletou, name);
                break;
            case R.id.fucai3d:
                name = getResources().getString(R.string.fucai3d);
                goToDetails(Constants.fucai3d, name);
                break;
            case R.id.pailei3:
                name = getResources().getString(R.string.pailei3);
                goToDetails(Constants.pailei3, name);
                break;
            case R.id.pailie5:
                name = getResources().getString(R.string.pailei5);
                goToDetails(Constants.pailie5, name);
                break;
            case R.id.shishicai:
                name = getResources().getString(R.string.shishicai);
                goToDetails(Constants.shishicai, name);
                break;
            case R.id.qixingcai:
                name = getResources().getString(R.string.qixingcai);
                goToDetails(Constants.qixingcai, name);
                break;
            case R.id.qilecai:
                name = getResources().getString(R.string.qilecai);
                goToDetails(Constants.qilecai, name);
                break;
            case R.id.xuan115:
                name = getResources().getString(R.string.xuan115);
                goToDetails(Constants.xuan115, name);
                break;
            case R.id.kaile3:
                name = getResources().getString(R.string.kaile3);
                goToDetails(Constants.kaile3, name);
                break;
            case R.id.kaile8:
                name = getResources().getString(R.string.kaile8);
                goToDetails(Constants.kaile8, name);
                break;
            case R.id.kaile10:
                name = getResources().getString(R.string.kaile10);
                goToDetails(Constants.kaile10, name);
                break;
        }
    }

    private void goToDetails(final String urlType, final String name) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("url", urlType);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    /**
     * 吐司
     *
     * @param message
     */
    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        System.out.print("创建数据失败：------------------------------------->:" + message);
    }

    private boolean isFirst = true;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isFirst) {
                Toast.makeText(MainActivity.this, "再按一次退出应用", Toast.LENGTH_LONG).show();
                isFirst = !isFirst;
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
