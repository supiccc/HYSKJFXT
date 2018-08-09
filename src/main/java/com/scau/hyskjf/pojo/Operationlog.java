package com.scau.hyskjf.pojo;

import java.util.Date;

public class Operationlog {
    private Integer ologid;

    private Integer macid;

    private Integer ologaccount;

    private Date ologtime;

    private String ologurl;

    private String ologfuntion;

    public Integer getOlogid() {
        return ologid;
    }

    public void setOlogid(Integer ologid) {
        this.ologid = ologid;
    }

    public Integer getMacid() {
        return macid;
    }

    public void setMacid(Integer macid) {
        this.macid = macid;
    }

    public Integer getOlogaccount() {
        return ologaccount;
    }

    public void setOlogaccount(Integer ologaccount) {
        this.ologaccount = ologaccount;
    }

    public Date getOlogtime() {
        return ologtime;
    }

    public void setOlogtime(Date ologtime) {
        this.ologtime = ologtime;
    }

    public String getOlogurl() {
        return ologurl;
    }

    public void setOlogurl(String ologurl) {
        this.ologurl = ologurl;
    }

    public String getOlogfuntion() {
        return ologfuntion;
    }

    public void setOlogfuntion(String ologfuntion) {
        this.ologfuntion = ologfuntion;
    }
}