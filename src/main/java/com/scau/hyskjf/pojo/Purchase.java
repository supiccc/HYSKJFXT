package com.scau.hyskjf.pojo;

import java.util.Date;

public class Purchase {
    private Integer purid;

    private Long memid;

    private Long mcid;

    private Integer purbelong;

    private Integer purmerchant;

    private Float purmoney;

    private Float purremain;

    private Date purtime;

    public Integer getPurid() {
        return purid;
    }

    public void setPurid(Integer purid) {
        this.purid = purid;
    }

    public Long getMemid() {
        return memid;
    }

    public void setMemid(Long memid) {
        this.memid = memid;
    }

    public Long getMcid() {
        return mcid;
    }

    public void setMcid(Long mcid) {
        this.mcid = mcid;
    }

    public Integer getPurbelong() {
        return purbelong;
    }

    public void setPurbelong(Integer purbelong) {
        this.purbelong = purbelong;
    }

    public Integer getPurmerchant() {
        return purmerchant;
    }

    public void setPurmerchant(Integer purmerchant) {
        this.purmerchant = purmerchant;
    }

    public Float getPurmoney() {
        return purmoney;
    }

    public void setPurmoney(Float purmoney) {
        this.purmoney = purmoney;
    }

    public Float getPurremain() {
        return purremain;
    }

    public void setPurremain(Float purremain) {
        this.purremain = purremain;
    }

    public Date getPurtime() {
        return purtime;
    }

    public void setPurtime(Date purtime) {
        this.purtime = purtime;
    }
}