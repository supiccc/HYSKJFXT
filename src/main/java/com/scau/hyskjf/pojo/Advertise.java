package com.scau.hyskjf.pojo;

import java.util.Date;

public class Advertise {
    private Integer adverid;

    private Integer merid;

    private String adverimage;

    private String adverurl;

    private String advertype;

    private Float advercost;

    private Date adverstart;

    private Date adverend;

    private String adverdescript;

    public Integer getAdverid() {
        return adverid;
    }

    public void setAdverid(Integer adverid) {
        this.adverid = adverid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public String getAdverimage() {
        return adverimage;
    }

    public void setAdverimage(String adverimage) {
        this.adverimage = adverimage;
    }

    public String getAdverurl() {
        return adverurl;
    }

    public void setAdverurl(String adverurl) {
        this.adverurl = adverurl;
    }

    public String getAdvertype() {
        return advertype;
    }

    public void setAdvertype(String advertype) {
        this.advertype = advertype;
    }

    public Float getAdvercost() {
        return advercost;
    }

    public void setAdvercost(Float advercost) {
        this.advercost = advercost;
    }

    public Date getAdverstart() {
        return adverstart;
    }

    public void setAdverstart(Date adverstart) {
        this.adverstart = adverstart;
    }

    public Date getAdverend() {
        return adverend;
    }

    public void setAdverend(Date adverend) {
        this.adverend = adverend;
    }

    public String getAdverdescript() {
        return adverdescript;
    }

    public void setAdverdescript(String adverdescript) {
        this.adverdescript = adverdescript;
    }
}