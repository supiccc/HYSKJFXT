package com.scau.hyskjf.pojo;

public class Membercard extends MembercardKey {
    private Integer merid;

    private String mctype;

    private Float mccredit;

    private Float mcbalance;

    private Boolean mcenable;

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public String getMctype() {
        return mctype;
    }

    public void setMctype(String mctype) {
        this.mctype = mctype;
    }

    public Float getMccredit() {
        return mccredit;
    }

    public void setMccredit(Float mccredit) {
        this.mccredit = mccredit;
    }

    public Float getMcbalance() {
        return mcbalance;
    }

    public void setMcbalance(Float mcbalance) {
        this.mcbalance = mcbalance;
    }

    public Boolean getMcenable() {
        return mcenable;
    }

    public void setMcenable(Boolean mcenable) {
        this.mcenable = mcenable;
    }
}