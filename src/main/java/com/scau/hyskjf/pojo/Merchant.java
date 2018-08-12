package com.scau.hyskjf.pojo;

public class Merchant {
    private Integer merid;

    private Integer mersubid;

    private Integer mertopid;

    private String mertype;

    private String mername;

    private Float mercumpresent;

    private Float merdicpresent;

    private Boolean merappstat;

    private Boolean merrecommend;

    private Byte isindex;

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public Integer getMersubid() {
        return mersubid;
    }

    public void setMersubid(Integer mersubid) {
        this.mersubid = mersubid;
    }

    public Integer getMertopid() {
        return mertopid;
    }

    public void setMertopid(Integer mertopid) {
        this.mertopid = mertopid;
    }

    public String getMertype() {
        return mertype;
    }

    public void setMertype(String mertype) {
        this.mertype = mertype;
    }

    public String getMername() {
        return mername;
    }

    public void setMername(String mername) {
        this.mername = mername;
    }

    public Float getMercumpresent() {
        return mercumpresent;
    }

    public void setMercumpresent(Float mercumpresent) {
        this.mercumpresent = mercumpresent;
    }

    public Float getMerdicpresent() {
        return merdicpresent;
    }

    public void setMerdicpresent(Float merdicpresent) {
        this.merdicpresent = merdicpresent;
    }

    public Boolean getMerappstat() {
        return merappstat;
    }

    public void setMerappstat(Boolean merappstat) {
        this.merappstat = merappstat;
    }

    public Boolean getMerrecommend() {
        return merrecommend;
    }

    public void setMerrecommend(Boolean merrecommend) {
        this.merrecommend = merrecommend;
    }

    public Byte getIsindex() {
        return isindex;
    }

    public void setIsindex(Byte isindex) {
        this.isindex = isindex;
    }
}