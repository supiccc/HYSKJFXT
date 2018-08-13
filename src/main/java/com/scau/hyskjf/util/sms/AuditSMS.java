package com.scau.hyskjf.util.sms;

import com.scau.hyskjf.util.sms.common.Config;
import com.scau.hyskjf.util.sms.common.HttpUtil;

import java.net.URLEncoder;
import java.text.MessageFormat;

/**
 * Created by supiccc on 2018-08-12 12:39
 */
public class AuditSMS {
    private static String operation = "/industrySMS/sendSMS";

    private static String accountSid = Config.ACCOUNT_SID;
    private static String to = "";
    private static String smsContent = "";

    /**
     * 审核未通过通知短信
     */
    public static String nopass(String phonenumber, String user, String store)
    {
        to = phonenumber;
        smsContent = MessageFormat.format("【华迪科技】尊敬的{0}，您的商家名称为：{1}的入盟申请未通过审核。", user, store);
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
        return result;
    }


}
