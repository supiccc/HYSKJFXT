package com.scau.hyskjf.pojo;

import java.util.Date;

public class Reissuedetail {
    private Integer memid;

    private Integer mcpkid;

    private Integer reiid;

    private Date reitime;

    private String mcid;

    private Integer merid;

    private String mctype;

    private Float mccredit;

    private Float mcbalance;

    private Boolean mcenable;

    private String reireason;

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public Integer getMcpkid() {
        return mcpkid;
    }

    public void setMcpkid(Integer mcpkid) {
        this.mcpkid = mcpkid;
    }

    public Integer getReiid() {
        return reiid;
    }

    public void setReiid(Integer reiid) {
        this.reiid = reiid;
    }

    public Date getReitime() {
        return reitime;
    }

    public void setReitime(Date reitime) {
        this.reitime = reitime;
    }

    public String getMcid() {
        return mcid;
    }

    public void setMcid(String mcid) {
        this.mcid = mcid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public String getMctype() {
        return mctype;
    }

    public void setMctype(String mctype) {
        this.mctype = mctype;
    }

    public Float getMccredit() {
        return mccredit;
    }

    public void setMccredit(Float mccredit) {
        this.mccredit = mccredit;
    }

    public Float getMcbalance() {
        return mcbalance;
    }

    public void setMcbalance(Float mcbalance) {
        this.mcbalance = mcbalance;
    }

    public Boolean getMcenable() {
        return mcenable;
    }

    public void setMcenable(Boolean mcenable) {
        this.mcenable = mcenable;
    }

    public String getReireason() {
        return reireason;
    }

    public void setReireason(String reireason) {
        this.reireason = reireason;
    }
}