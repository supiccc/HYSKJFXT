package com.scau.hyskjf.pojo;

import java.util.Date;

public class Suggestion {
    private Integer sugid;

    private Integer merid;

    private String sugtitle;

    private Date sugdate;

    private String sugcontent;

    public Integer getSugid() {
        return sugid;
    }

    public void setSugid(Integer sugid) {
        this.sugid = sugid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public String getSugtitle() {
        return sugtitle;
    }

    public void setSugtitle(String sugtitle) {
        this.sugtitle = sugtitle;
    }

    public Date getSugdate() {
        return sugdate;
    }

    public void setSugdate(Date sugdate) {
        this.sugdate = sugdate;
    }

    public String getSugcontent() {
        return sugcontent;
    }

    public void setSugcontent(String sugcontent) {
        this.sugcontent = sugcontent;
    }
}