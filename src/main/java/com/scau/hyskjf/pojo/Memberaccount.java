package com.scau.hyskjf.pojo;

import java.io.Serializable;

public class Memberaccount implements Serializable {
    private Integer memid;

    private String maid;

    private String maname;

    private String mapwd;

    private String macumpwd;

    private Boolean maenable;

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public String getMaid() {
        return maid;
    }

    public void setMaid(String maid) {
        this.maid = maid;
    }

    public String getManame() {
        return maname;
    }

    public void setManame(String maname) {
        this.maname = maname;
    }

    public String getMapwd() {
        return mapwd;
    }

    public void setMapwd(String mapwd) {
        this.mapwd = mapwd;
    }

    public String getMacumpwd() {
        return macumpwd;
    }

    public void setMacumpwd(String macumpwd) {
        this.macumpwd = macumpwd;
    }

    public Boolean getMaenable() {
        return maenable;
    }

    public void setMaenable(Boolean maenable) {
        this.maenable = maenable;
    }
}