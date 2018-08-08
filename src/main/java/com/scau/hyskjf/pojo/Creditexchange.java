package com.scau.hyskjf.pojo;

import java.util.Date;

public class Creditexchange {
    private Integer ceid;

    private String cestat;

    private Long memid;

    private Long mcid;

    private String ceways;

    private Integer ceamount;

    private Float cecost;

    private Date cetime;

    public Integer getCeid() {
        return ceid;
    }

    public void setCeid(Integer ceid) {
        this.ceid = ceid;
    }

    public String getCestat() {
        return cestat;
    }

    public void setCestat(String cestat) {
        this.cestat = cestat;
    }

    public Long getMemid() {
        return memid;
    }

    public void setMemid(Long memid) {
        this.memid = memid;
    }

    public Long getMcid() {
        return mcid;
    }

    public void setMcid(Long mcid) {
        this.mcid = mcid;
    }

    public String getCeways() {
        return ceways;
    }

    public void setCeways(String ceways) {
        this.ceways = ceways;
    }

    public Integer getCeamount() {
        return ceamount;
    }

    public void setCeamount(Integer ceamount) {
        this.ceamount = ceamount;
    }

    public Float getCecost() {
        return cecost;
    }

    public void setCecost(Float cecost) {
        this.cecost = cecost;
    }

    public Date getCetime() {
        return cetime;
    }

    public void setCetime(Date cetime) {
        this.cetime = cetime;
    }
}