package com.scau.hyskjf.pojo;

import java.util.Date;

public class Reissue {
    private Integer reiid;

    private Long memid;

    private Date reitime;

    private Long reioldnum;

    private Long reinewnum;

    private String reireason;

    public Integer getReiid() {
        return reiid;
    }

    public void setReiid(Integer reiid) {
        this.reiid = reiid;
    }

    public Long getMemid() {
        return memid;
    }

    public void setMemid(Long memid) {
        this.memid = memid;
    }

    public Date getReitime() {
        return reitime;
    }

    public void setReitime(Date reitime) {
        this.reitime = reitime;
    }

    public Long getReioldnum() {
        return reioldnum;
    }

    public void setReioldnum(Long reioldnum) {
        this.reioldnum = reioldnum;
    }

    public Long getReinewnum() {
        return reinewnum;
    }

    public void setReinewnum(Long reinewnum) {
        this.reinewnum = reinewnum;
    }

    public String getReireason() {
        return reireason;
    }

    public void setReireason(String reireason) {
        this.reireason = reireason;
    }
}