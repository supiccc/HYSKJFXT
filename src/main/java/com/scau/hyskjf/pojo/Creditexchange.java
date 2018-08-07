package com.scau.hyskjf.pojo;

import java.util.Date;

public class Creditexchange {
    private Integer ceid;

    private String cestat;

    private Long memid;

    private Long mcid;

    private String ceways;

    private String ceitem;

    private Integer ceamount;

    private Float cecost;

    private String ceadress;

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

    public String getCeitem() {
        return ceitem;
    }

    public void setCeitem(String ceitem) {
        this.ceitem = ceitem;
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

    public String getCeadress() {
        return ceadress;
    }

    public void setCeadress(String ceadress) {
        this.ceadress = ceadress;
    }

    public Date getCetime() {
        return cetime;
    }

    public void setCetime(Date cetime) {
        this.cetime = cetime;
    }
}