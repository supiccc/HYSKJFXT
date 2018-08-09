package com.scau.hyskjf.pojo;

import java.util.Date;

public class Requirement {
    private Integer reqid;

    private Integer memid;

    private Date reqtime;

    private Integer reqby;

    private Boolean reqreply;

    private Integer reqrepby;

    private Date reqreptime;

    public Integer getReqid() {
        return reqid;
    }

    public void setReqid(Integer reqid) {
        this.reqid = reqid;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public Date getReqtime() {
        return reqtime;
    }

    public void setReqtime(Date reqtime) {
        this.reqtime = reqtime;
    }

    public Integer getReqby() {
        return reqby;
    }

    public void setReqby(Integer reqby) {
        this.reqby = reqby;
    }

    public Boolean getReqreply() {
        return reqreply;
    }

    public void setReqreply(Boolean reqreply) {
        this.reqreply = reqreply;
    }

    public Integer getReqrepby() {
        return reqrepby;
    }

    public void setReqrepby(Integer reqrepby) {
        this.reqrepby = reqrepby;
    }

    public Date getReqreptime() {
        return reqreptime;
    }

    public void setReqreptime(Date reqreptime) {
        this.reqreptime = reqreptime;
    }
}