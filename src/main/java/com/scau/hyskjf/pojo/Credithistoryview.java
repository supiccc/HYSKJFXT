package com.scau.hyskjf.pojo;

import org.springframework.stereotype.Repository;

public class Credithistoryview {
    private Integer merid;

    private Integer mcpkid;

    private Integer chid;

    private Float chcredit;

    private Float chremain;

    private Integer memid;

    private String mertype;

    private String mername;

    private String chtype;

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public Integer getMcpkid() {
        return mcpkid;
    }

    public void setMcpkid(Integer mcpkid) {
        this.mcpkid = mcpkid;
    }

    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
    }

    public Float getChcredit() {
        return chcredit;
    }

    public void setChcredit(Float chcredit) {
        this.chcredit = chcredit;
    }

    public Float getChremain() {
        return chremain;
    }

    public void setChremain(Float chremain) {
        this.chremain = chremain;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public String getMertype() {
        return mertype;
    }

    public void setMertype(String mertype) {
        this.mertype = mertype;
    }

    public String getMername() {
        return mername;
    }

    public void setMername(String mername) {
        this.mername = mername;
    }

    public String getChtype() {
        return chtype;
    }

    public void setChtype(String chtype) {
        this.chtype = chtype;
    }
}