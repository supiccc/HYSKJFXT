package com.scau.hyskjf.pojo;

import java.io.Serializable;
import java.util.Date;

public class Merchantaccount implements Serializable {
    private Integer macid;

    private Integer merid;

    private String macacc;

    private Integer maccumacc;

    private String macpasswd;

    private Integer macacctype;

    private Date maclastlogin;

    private Boolean macenable;

    public Integer getMacid() {
        return macid;
    }

    public void setMacid(Integer macid) {
        this.macid = macid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public String getMacacc() {
        return macacc;
    }

    public void setMacacc(String macacc) {
        this.macacc = macacc;
    }

    public Integer getMaccumacc() {
        return maccumacc;
    }

    public void setMaccumacc(Integer maccumacc) {
        this.maccumacc = maccumacc;
    }

    public String getMacpasswd() {
        return macpasswd;
    }

    public void setMacpasswd(String macpasswd) {
        this.macpasswd = macpasswd;
    }

    public Integer getMacacctype() {
        return macacctype;
    }

    public void setMacacctype(Integer macacctype) {
        this.macacctype = macacctype;
    }

    public Date getMaclastlogin() {
        return maclastlogin;
    }

    public void setMaclastlogin(Date maclastlogin) {
        this.maclastlogin = maclastlogin;
    }

    public Boolean getMacenable() {
        return macenable;
    }

    public void setMacenable(Boolean macenable) {
        this.macenable = macenable;
    }
}