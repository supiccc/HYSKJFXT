package com.scau.hyskjf.pojo;

import java.util.Date;

public class Creditconsume {
    private Integer creconid;

    private Integer memid;

    private Integer merid;

    private Integer adminid;

    private Float credits;

    private Float value;

    private Boolean handlestate;

    private Date recordtime;

    private Boolean transferstate;

    private Date handletime;

    public Integer getCreconid() {
        return creconid;
    }

    public void setCreconid(Integer creconid) {
        this.creconid = creconid;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Float getCredits() {
        return credits;
    }

    public void setCredits(Float credits) {
        this.credits = credits;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean getHandlestate() {
        return handlestate;
    }

    public void setHandlestate(Boolean handlestate) {
        this.handlestate = handlestate;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public Boolean getTransferstate() {
        return transferstate;
    }

    public void setTransferstate(Boolean transferstate) {
        this.transferstate = transferstate;
    }

    public Date getHandletime() {
        return handletime;
    }

    public void setHandletime(Date handletime) {
        this.handletime = handletime;
    }
}