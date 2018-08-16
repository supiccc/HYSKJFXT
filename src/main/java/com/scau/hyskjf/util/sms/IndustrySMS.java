package com.scau.hyskjf.util.sms;

import com.scau.hyskjf.util.sms.common.Config;
import com.scau.hyskjf.util.sms.common.HttpUtil;
import com.scau.hyskjf.util.sms.common.VerficationCode;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by supiccc on 2018-08-12 11:59
 */
public class IndustrySMS {
    private static String operation = "/industrySMS/sendSMS";

    private static String accountSid = Config.ACCOUNT_SID;
    private static String to = "";
    private static String smsContent = "";

    /**
     * 验证码通知短信
     */
    public static Map execute(String phonenumber)
    {
        to = phonenumber;
        smsContent = "【华迪科技】您的验证码为";
        String verficationCode = VerficationCode.getCode();
        smsContent += verficationCode + "，请于5分钟内正确输入，如非本人操作，请忽略此短信。";
        String tmpSmsContent = null;
        try{
            tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
        }catch(Exception e){

        }
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
                + HttpUtil.createCommonParam();

        // 提交请求
        String result = HttpUtil.post(url, body);
        System.out.println("result:" + System.lineSeparator() + result);
        JSONObject o = new JSONObject(result);
        Map r = new HashMap();
        r.put("verficationCode", verficationCode);
        r.put("result", o.get("respDesc"));
        return r;
    }
}
