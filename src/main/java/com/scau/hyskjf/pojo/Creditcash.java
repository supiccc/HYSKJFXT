package com.scau.hyskjf.pojo;

import java.util.Date;

public class Creditcash {
    private Integer ccid;

    private Integer mcpkid;

    private String ccways;

    private String ccbankaccount;

    private Float cccredit;

    private Float ccmoney;

    private Date cctime0;

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    public Integer getMcpkid() {
        return mcpkid;
    }

    public void setMcpkid(Integer mcpkid) {
        this.mcpkid = mcpkid;
    }

    public String getCcways() {
        return ccways;
    }

    public void setCcways(String ccways) {
        this.ccways = ccways;
    }

    public String getCcbankaccount() {
        return ccbankaccount;
    }

    public void setCcbankaccount(String ccbankaccount) {
        this.ccbankaccount = ccbankaccount;
    }

    public Float getCccredit() {
        return cccredit;
    }

    public void setCccredit(Float cccredit) {
        this.cccredit = cccredit;
    }

    public Float getCcmoney() {
        return ccmoney;
    }

    public void setCcmoney(Float ccmoney) {
        this.ccmoney = ccmoney;
    }

    public Date getCctime0() {
        return cctime0;
    }

    public void setCctime0(Date cctime0) {
        this.cctime0 = cctime0;
    }
}