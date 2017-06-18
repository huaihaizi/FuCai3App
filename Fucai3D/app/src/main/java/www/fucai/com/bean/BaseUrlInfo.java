package www.fucai.com.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lenovo on 2017/6/16.
 */

public class BaseUrlInfo implements Serializable {
    /**
     * rows : 20
     * code : dlt
     * info : 免费接口随机延迟3-6分钟，实时接口请访问opencai.net或QQ:23081452(注明彩票或API)
     * data : [{"expect":"2017068","opencode":"07,08,19,24,27+06,07","opentime":"2017-06-14 20:33:20","opentimestamp":1497443600},{"expect":"2017067","opencode":"10,17,18,32,35+10,11","opentime":"2017-06-12 20:33:20","opentimestamp":1497270800},{"expect":"2017066","opencode":"11,15,23,26,30+02,11","opentime":"2017-06-10 20:33:20","opentimestamp":1497098000},{"expect":"2017065","opencode":"05,11,12,19,28+05,12","opentime":"2017-06-07 20:33:20","opentimestamp":1496838800},{"expect":"2017064","opencode":"01,08,20,27,30+03,04","opentime":"2017-06-05 20:33:20","opentimestamp":1496666000},{"expect":"2017063","opencode":"18,21,22,24,29+05,11","opentime":"2017-06-03 20:33:20","opentimestamp":1496493200},{"expect":"2017062","opencode":"01,04,06,08,28+08,12","opentime":"2017-05-31 20:33:20","opentimestamp":1496234000},{"expect":"2017061","opencode":"10,19,23,25,30+02,04","opentime":"2017-05-29 20:33:20","opentimestamp":1496061200},{"expect":"2017060","opencode":"09,15,20,26,31+05,12","opentime":"2017-05-27 20:33:20","opentimestamp":1495888400},{"expect":"2017059","opencode":"08,11,13,15,17+03,10","opentime":"2017-05-24 20:33:20","opentimestamp":1495629200},{"expect":"2017058","opencode":"14,18,20,21,28+03,06","opentime":"2017-05-22 20:33:20","opentimestamp":1495456400},{"expect":"2017057","opencode":"12,16,19,23,24+02,05","opentime":"2017-05-20 20:33:20","opentimestamp":1495283600},{"expect":"2017056","opencode":"01,04,24,27,32+03,10","opentime":"2017-05-17 20:33:20","opentimestamp":1495024400},{"expect":"2017055","opencode":"19,20,22,30,33+03,09","opentime":"2017-05-15 20:33:20","opentimestamp":1494851600},{"expect":"2017054","opencode":"16,29,30,32,33+04,05","opentime":"2017-05-13 20:33:20","opentimestamp":1494678800},{"expect":"2017053","opencode":"06,19,20,22,26+01,11","opentime":"2017-05-10 20:33:20","opentimestamp":1494419600},{"expect":"2017052","opencode":"03,19,24,28,33+04,12","opentime":"2017-05-08 20:33:20","opentimestamp":1494246800},{"expect":"2017051","opencode":"14,17,18,22,29+10,11","opentime":"2017-05-06 20:33:20","opentimestamp":1494074000},{"expect":"2017050","opencode":"12,14,17,20,28+02,06","opentime":"2017-05-03 20:33:20","opentimestamp":1493814800},{"expect":"2017049","opencode":"09,12,14,22,31+05,08","opentime":"2017-05-01 20:33:20","opentimestamp":1493642000}]
     */
    private int rows;
    private String code;
    private String info;
    private List<DataBean> data;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


}
