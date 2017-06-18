package www.fucai.com.bean;

import java.io.Serializable;

/**
 * Created by Lenovo on 2017/6/16.
 */

public  class DataBean implements Serializable{
    /**
     * expect : 2017068
     * opencode : 07,08,19,24,27+06,07
     * opentime : 2017-06-14 20:33:20
     * opentimestamp : 1497443600
     */
    private String expect;
    private String opencode;
    private String opentime;
    private int opentimestamp;

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getOpencode() {
        return opencode;
    }

    public void setOpencode(String opencode) {
        this.opencode = opencode;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public int getOpentimestamp() {
        return opentimestamp;
    }

    public void setOpentimestamp(int opentimestamp) {
        this.opentimestamp = opentimestamp;
    }
}
