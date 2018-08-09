package com.scau.hyskjf.pojo;

import java.util.Date;

public class Membermanager {
    private Integer mmaid;

    private Integer memid;

    private Integer macid;

    private Date mmatime;

    private Integer mmanagerid;

    public Integer getMmaid() {
        return mmaid;
    }

    public void setMmaid(Integer mmaid) {
        this.mmaid = mmaid;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public Integer getMacid() {
        return macid;
    }

    public void setMacid(Integer macid) {
        this.macid = macid;
    }

    public Date getMmatime() {
        return mmatime;
    }

    public void setMmatime(Date mmatime) {
        this.mmatime = mmatime;
    }

    public Integer getMmanagerid() {
        return mmanagerid;
    }

    public void setMmanagerid(Integer mmanagerid) {
        this.mmanagerid = mmanagerid;
    }
}