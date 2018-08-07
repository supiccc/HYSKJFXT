package com.scau.hyskjf.pojo;

import java.util.Date;

public class Adminlog {
    private Integer adlogid;

    private Integer adminid;

    private String adlogfunction;

    private Date adlogtime;

    private String adloginfo;

    public Integer getAdlogid() {
        return adlogid;
    }

    public void setAdlogid(Integer adlogid) {
        this.adlogid = adlogid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdlogfunction() {
        return adlogfunction;
    }

    public void setAdlogfunction(String adlogfunction) {
        this.adlogfunction = adlogfunction;
    }

    public Date getAdlogtime() {
        return adlogtime;
    }

    public void setAdlogtime(Date adlogtime) {
        this.adlogtime = adlogtime;
    }

    public String getAdloginfo() {
        return adloginfo;
    }

    public void setAdloginfo(String adloginfo) {
        this.adloginfo = adloginfo;
    }
}