package com.scau.hyskjf.util.json;

/**
 * Created by supiccc on 2018-08-07 19:30
 * 包括状态码、描述、数据
 */

public class ResponseJSON {
    private int code;
    private String msg;
    private Object data;

    public ResponseJSON(ResponseCode respCode) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public ResponseJSON(ResponseCode respCode, Object data) {
        this(respCode);
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}


