package www.fucai.com.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lenovo on 2017/6/16.
 */
public class AppUtils {

    /**
     * 转化时间格式
     *
     * @param time
     * @return
     */
    public static String getDate(String time) {
        if(TextUtils.isEmpty(time)){
            return "";
        }else{
            String datestr = "";
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = timeFormat.parse(time);
                datestr = dateFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return datestr;
        }
    }

}
