package com.scau.hyskjf.util.json;

/**
 * Created by supiccc on 2018-08-07 19:37
 */
public enum ResponseCode {

    SUCCESS(0, "请求成功"),
    WARN(-1, "网络异常，请稍后重试"),
    UNKNOWNACCOUNT(-1, "账号不存在"),
    INCORRECTPWD(-1, "密码错误"),
    NOTFOUND(-1,"没有查到");

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
