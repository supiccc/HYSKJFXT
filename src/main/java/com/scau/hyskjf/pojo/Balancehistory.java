package com.scau.hyskjf.pojo;

import java.util.Date;

public class Balancehistory {
    private Integer vhid;

    private Long memid;

    private Long mcid;

    private Float vhmoney;

    private Date vhtime;

    public Integer getVhid() {
        return vhid;
    }

    public void setVhid(Integer vhid) {
        this.vhid = vhid;
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

    public Float getVhmoney() {
        return vhmoney;
    }

    public void setVhmoney(Float vhmoney) {
        this.vhmoney = vhmoney;
    }

    public Date getVhtime() {
        return vhtime;
    }

    public void setVhtime(Date vhtime) {
        this.vhtime = vhtime;
    }
}