package www.fucai.com.adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.fucai.com.R;
import www.fucai.com.bean.DataBean;
import www.fucai.com.utils.AppUtils;

/**
 * Created by Lenovo on 2017/6/16.
 */

public class ListViewAdapter extends BaseAdapter {
    private List<DataBean> dataBeanInfoList;
    private Context context;

    public ListViewAdapter(Context context, List<DataBean> dataBeanInfoList) {
        this.context = context;
        this.dataBeanInfoList = dataBeanInfoList;
    }

    @Override
    public int getCount() {
        return dataBeanInfoList == null || dataBeanInfoList.isEmpty() ? 0 : dataBeanInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_listview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (dataBeanInfoList != null && !dataBeanInfoList.isEmpty() && position < dataBeanInfoList.size()) {
            DataBean dataBean = dataBeanInfoList.get(position);
            String time = "";
            String opencode = "";
            String expect = "";
            if (dataBean != null) {
                if (!TextUtils.isEmpty(dataBean.getOpentime())) {
                    time = dataBean.getOpentime();
                }
                if (!TextUtils.isEmpty(dataBean.getOpencode())) {
                    opencode = dataBean.getOpencode();
                }
                if (!TextUtils.isEmpty(dataBean.getExpect())) {
                    expect = dataBean.getExpect();
                }
                String font = "<font color='#4ac3f6'>" + expect + "</font>";
                String date = AppUtils.getDate(time);
                holder.info_textview.setText(Html.fromHtml("第 " + font + " 期 " + date));
                holder.result_textview.setText(opencode);
            }

        }

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.info_textview)
        TextView info_textview;
        @BindView(R.id.result_textview)
        TextView result_textview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
