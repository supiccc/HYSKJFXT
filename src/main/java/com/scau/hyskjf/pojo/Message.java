package com.scau.hyskjf.pojo;

import java.util.Date;

public class Message {
    private Integer mesid;

    private String mestitle;

    private Integer messource;

    private Integer mesdestination;

    private Boolean mesread;

    private Integer mestype;

    private String mescontent;

    private Date mestime;

    public Integer getMesid() {
        return mesid;
    }

    public void setMesid(Integer mesid) {
        this.mesid = mesid;
    }

    public String getMestitle() {
        return mestitle;
    }

    public void setMestitle(String mestitle) {
        this.mestitle = mestitle;
    }

    public Integer getMessource() {
        return messource;
    }

    public void setMessource(Integer messource) {
        this.messource = messource;
    }

    public Integer getMesdestination() {
        return mesdestination;
    }

    public void setMesdestination(Integer mesdestination) {
        this.mesdestination = mesdestination;
    }

    public Boolean getMesread() {
        return mesread;
    }

    public void setMesread(Boolean mesread) {
        this.mesread = mesread;
    }

    public Integer getMestype() {
        return mestype;
    }

    public void setMestype(Integer mestype) {
        this.mestype = mestype;
    }

    public String getMescontent() {
        return mescontent;
    }

    public void setMescontent(String mescontent) {
        this.mescontent = mescontent;
    }


    public Date getMestime() {
        return mestime;
    }

    public void setMestime(Date mestime) {
        this.mestime = mestime;
    }
}