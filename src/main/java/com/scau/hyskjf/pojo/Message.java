package com.scau.hyskjf.pojo;

public class Message {
    private Integer mesid;

    private String mestitle;

    private Integer messource;

    private Integer mesdestination;

    private Boolean mesread;

    private String mescontent;

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

    public String getMescontent() {
        return mescontent;
    }

    public void setMescontent(String mescontent) {
        this.mescontent = mescontent;
    }
}