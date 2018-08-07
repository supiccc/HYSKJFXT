package com.scau.hyskjf.pojo;

import java.util.Date;

public class Membermanager {
    private Integer mmaid;

    private Long memid;

    private Integer merid;

    private Integer macid;

    private Date mmatime;

    private Integer mmanagerid;

    public Integer getMmaid() {
        return mmaid;
    }

    public void setMmaid(Integer mmaid) {
        this.mmaid = mmaid;
    }

    public Long getMemid() {
        return memid;
    }

    public void setMemid(Long memid) {
        this.memid = memid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
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