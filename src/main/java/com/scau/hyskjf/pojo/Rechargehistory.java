package com.scau.hyskjf.pojo;

import java.util.Date;

public class Rechargehistory {
    private Integer rhid;

    private Integer merid;

    private Integer memid;

    private Integer macid;

    private String mcid;

    private Float rechargemoney;

    private Float balance;

    private Date rechargetime;

    public Integer getRhid() {
        return rhid;
    }

    public void setRhid(Integer rhid) {
        this.rhid = rhid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public Integer getMacid() {
        return macid;
    }

    public void setMacid(Integer macid) {
        this.macid = macid;
    }

    public String getMcid() {
        return mcid;
    }

    public void setMcid(String mcid) {
        this.mcid = mcid;
    }

    public Float getRechargemoney() {
        return rechargemoney;
    }

    public void setRechargemoney(Float rechargemoney) {
        this.rechargemoney = rechargemoney;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Date getRechargetime() {
        return rechargetime;
    }

    public void setRechargetime(Date rechargetime) {
        this.rechargetime = rechargetime;
    }
}