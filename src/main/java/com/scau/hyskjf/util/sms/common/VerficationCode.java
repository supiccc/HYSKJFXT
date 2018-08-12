package com.scau.hyskjf.util.sms.common;

/**
 * Created by supiccc on 2018-08-12 12:17
 */
public class VerficationCode {
    private static String code = "";

    public static String getCode() {
        code = "";
        for (int i = 0; i < 4; i++) {
            code += String.valueOf((int)(0 + Math.random()*10));
        }
        System.out.println(code);
        return code;
    }
}
