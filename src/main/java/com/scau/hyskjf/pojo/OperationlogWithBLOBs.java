package com.scau.hyskjf.pojo;

public class OperationlogWithBLOBs extends Operationlog {
    private String ologoperation;

    private String ologinfo;

    public String getOlogoperation() {
        return ologoperation;
    }

    public void setOlogoperation(String ologoperation) {
        this.ologoperation = ologoperation;
    }

    public String getOloginfo() {
        return ologinfo;
    }

    public void setOloginfo(String ologinfo) {
        this.ologinfo = ologinfo;
    }
}