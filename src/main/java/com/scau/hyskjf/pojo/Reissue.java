package com.scau.hyskjf.pojo;

import java.util.Date;

public class Reissue {
    private Integer reiid;

    private Integer memid;

    private Date reitime;

    private Integer mcpkid;

    private String reireason;

    public Integer getReiid() {
        return reiid;
    }

    public void setReiid(Integer reiid) {
        this.reiid = reiid;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public Date getReitime() {
        return reitime;
    }

    public void setReitime(Date reitime) {
        this.reitime = reitime;
    }

    public Integer getMcpkid() {
        return mcpkid;
    }

    public void setMcpkid(Integer mcpkid) {
        this.mcpkid = mcpkid;
    }

    public String getReireason() {
        return reireason;
    }

    public void setReireason(String reireason) {
        this.reireason = reireason;
    }
}