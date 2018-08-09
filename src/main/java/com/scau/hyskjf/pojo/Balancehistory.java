package com.scau.hyskjf.pojo;

import java.util.Date;

public class Balancehistory {
    private Integer vhid;

    private Integer mcpkid;

    private Float vhmoney;

    private Date vhtime;

    public Integer getVhid() {
        return vhid;
    }

    public void setVhid(Integer vhid) {
        this.vhid = vhid;
    }

    public Integer getMcpkid() {
        return mcpkid;
    }

    public void setMcpkid(Integer mcpkid) {
        this.mcpkid = mcpkid;
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