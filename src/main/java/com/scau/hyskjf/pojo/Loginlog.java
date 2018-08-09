package com.scau.hyskjf.pojo;

import java.util.Date;

public class Loginlog {
    private Integer llogid;

    private Integer macid;

    private Integer llogaccount;

    private Date llogdate;

    private String llogtype;

    public Integer getLlogid() {
        return llogid;
    }

    public void setLlogid(Integer llogid) {
        this.llogid = llogid;
    }

    public Integer getMacid() {
        return macid;
    }

    public void setMacid(Integer macid) {
        this.macid = macid;
    }

    public Integer getLlogaccount() {
        return llogaccount;
    }

    public void setLlogaccount(Integer llogaccount) {
        this.llogaccount = llogaccount;
    }

    public Date getLlogdate() {
        return llogdate;
    }

    public void setLlogdate(Date llogdate) {
        this.llogdate = llogdate;
    }

    public String getLlogtype() {
        return llogtype;
    }

    public void setLlogtype(String llogtype) {
        this.llogtype = llogtype;
    }
}