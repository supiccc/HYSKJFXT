package com.scau.hyskjf.pojo;

/**
 * Created by supiccc on 2018-08-13 16:26
 */
public class ConsumedetailFormatTime extends Consumedetail {
    private String date;
    private String evabyN; // 评论用户名

    public String getEvabyN() {
        return evabyN;
    }

    public void setEvabyN(String evabyN) {
        this.evabyN = evabyN;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
