package com.scau.hyskjf.pojo;

public class Memberaccount {
    private Integer memid;

    private Integer maid;

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

    public Integer getMaid() {
        return maid;
    }

    public void setMaid(Integer maid) {
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