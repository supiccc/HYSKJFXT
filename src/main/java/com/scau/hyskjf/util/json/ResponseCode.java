package com.scau.hyskjf.util.json;

/**
 * Created by supiccc on 2018-08-07 19:37
 */
public enum ResponseCode {

    SUCCESS(0, "请求成功"),
    WARN(-1, "请求失败"),
    UNKNOWNACCOUNT(-1, "账号不存在"),
    INCORRECTPWD(-1, "密码错误"),
    HASLOGIN(-1, "用户已登录"),
    NOTFOUND(-1,"没有查到"),
    ILLEGALCODE(-1, "非法入参"),
    NOTLOGIN(-1, "未登录"),
    ERRORCARD(-2, "会员卡号错误"),
    ERRORSHOPPWD(-3, "消费密码错误"),
    LACKCREDIT(-4, "积分不足"),
    LACKSTORE(-5, "储值余额不足");


    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
