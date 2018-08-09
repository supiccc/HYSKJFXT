package com.scau.hyskjf.pojo;

public class Credithistory {
    private Integer chid;

    private Integer mcpkid;

    private Float chcredit;

    private Float chremain;

    private String chtype;

    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
    }

    public Integer getMcpkid() {
        return mcpkid;
    }

    public void setMcpkid(Integer mcpkid) {
        this.mcpkid = mcpkid;
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