package www.fucai.com.utils;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by jianghm on 17/3/14.
 */

public class HttpCallUtils {

    /**
     * get请求
     * @param url
     * @return
     */
    public static Call sendGet(String url) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        return call;
    }


}
