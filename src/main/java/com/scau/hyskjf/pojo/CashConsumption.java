package com.scau.hyskjf.pojo;

public class CashConsumption {
    private Integer mcpkid;//会员卡主键ID

    private Integer memid;//会员id

    private Integer merid;//商家id

    private Integer checkResult;//验证结果

    private Float money;//消费金额

    private Float remainCredit;//修改后的积分

    private Float changeCredit;//获得的积分

    private Float mercumpresent;//消费积分比例

    public Integer getMcpkid() {
        return mcpkid;
    }

    public void setMcpkid(Integer mcpkid) {
        this.mcpkid = mcpkid;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public Integer getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(Integer checkResult) {
        this.checkResult = checkResult;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Float getRemainCredit() {
        return remainCredit;
    }

    public void setRemainCredit(Float remainCredit) {
        this.remainCredit = remainCredit;
    }

    public Float getChangeCredit() {
        return changeCredit;
    }

    public void setChangeCredit(Float changeCredit) {
        this.changeCredit = changeCredit;
    }

    public Float getMercumpresent() {
        return mercumpresent;
    }

    public void setMercumpresent(Float mercumpresent) {
        this.mercumpresent = mercumpresent;
    }
}
