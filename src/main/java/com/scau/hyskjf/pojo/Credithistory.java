package com.scau.hyskjf.pojo;

public class Credithistory {
    private Integer chid;

    private Long memid;

    private Long mcid;

    private Float chcredit;

    private Float chremain;

    private String chtype;

    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
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

    public String getChtype() {
        return chtype;
    }

    public void setChtype(String chtype) {
        this.chtype = chtype;
    }
}