package com.scau.hyskjf.pojo;

import java.util.Date;

public class Consume {
    private Integer cumid;

    private Integer mcpkid;

    private Float cummoney;

    private String cumway;

    private Float cumcredit;

    private Integer macid;

    private Date cumtime;

    public Integer getCumid() {
        return cumid;
    }

    public void setCumid(Integer cumid) {
        this.cumid = cumid;
    }

    public Integer getMcpkid() {
        return mcpkid;
    }

    public void setMcpkid(Integer mcpkid) {
        this.mcpkid = mcpkid;
    }

    public Float getCummoney() {
        return cummoney;
    }

    public void setCummoney(Float cummoney) {
        this.cummoney = cummoney;
    }

    public String getCumway() {
        return cumway;
    }

    public void setCumway(String cumway) {
        this.cumway = cumway;
    }

    public Float getCumcredit() {
        return cumcredit;
    }

    public void setCumcredit(Float cumcredit) {
        this.cumcredit = cumcredit;
    }

    public Integer getMacid() {
        return macid;
    }

    public void setMacid(Integer macid) {
        this.macid = macid;
    }

    public Date getCumtime() {
        return cumtime;
    }

    public void setCumtime(Date cumtime) {
        this.cumtime = cumtime;
    }
}