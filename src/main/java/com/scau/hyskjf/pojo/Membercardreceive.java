package com.scau.hyskjf.pojo;

import java.util.Date;

public class Membercardreceive {
    private Integer mcrid;

    private Integer adminid;

    private Integer merid;

    private Integer mcrreceivedcount;

    private String mcrzone;

    private Date mcrtime;

    public Integer getMcrid() {
        return mcrid;
    }

    public void setMcrid(Integer mcrid) {
        this.mcrid = mcrid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public Integer getMcrreceivedcount() {
        return mcrreceivedcount;
    }

    public void setMcrreceivedcount(Integer mcrreceivedcount) {
        this.mcrreceivedcount = mcrreceivedcount;
    }

    public String getMcrzone() {
        return mcrzone;
    }

    public void setMcrzone(String mcrzone) {
        this.mcrzone = mcrzone;
    }

    public Date getMcrtime() {
        return mcrtime;
    }

    public void setMcrtime(Date mcrtime) {
        this.mcrtime = mcrtime;
    }
}