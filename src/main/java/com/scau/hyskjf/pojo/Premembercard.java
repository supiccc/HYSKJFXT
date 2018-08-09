package com.scau.hyskjf.pojo;

import java.util.Date;

public class Premembercard {
    private Integer pmcid;

    private Integer merid;

    private Boolean pmcstat;

    private Integer pmcmermaker;

    private Integer pmcprovider;

    private Date pmcmaketime;

    private Date pmcprovidetime;

    public Integer getPmcid() {
        return pmcid;
    }

    public void setPmcid(Integer pmcid) {
        this.pmcid = pmcid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public Boolean getPmcstat() {
        return pmcstat;
    }

    public void setPmcstat(Boolean pmcstat) {
        this.pmcstat = pmcstat;
    }

    public Integer getPmcmermaker() {
        return pmcmermaker;
    }

    public void setPmcmermaker(Integer pmcmermaker) {
        this.pmcmermaker = pmcmermaker;
    }

    public Integer getPmcprovider() {
        return pmcprovider;
    }

    public void setPmcprovider(Integer pmcprovider) {
        this.pmcprovider = pmcprovider;
    }

    public Date getPmcmaketime() {
        return pmcmaketime;
    }

    public void setPmcmaketime(Date pmcmaketime) {
        this.pmcmaketime = pmcmaketime;
    }

    public Date getPmcprovidetime() {
        return pmcprovidetime;
    }

    public void setPmcprovidetime(Date pmcprovidetime) {
        this.pmcprovidetime = pmcprovidetime;
    }
}