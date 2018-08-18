package com.scau.hyskjf.controller;

import com.scau.hyskjf.dao.AdminMapper;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import com.scau.hyskjf.util.sms.AuditSMS;
import com.scau.hyskjf.util.sms.IndustrySMS;
import com.scau.hyskjf.util.sms.PassSMS;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by supiccc on 2018-08-07 17:11
 */
@RestController
//@RequestMapping("/admin")
//@Controller
public class DemoController {

    @Autowired
    AdminMapper adminMapper;

//    返回JSON示例
//    @RequestMapping(value = "1000")
//    @ResponseBody
//    public ResponseJSON pic() {
////        调用dao层
//        Admin user = adminMapper.selectByPrimaryKey(1000);
//        return new ResponseJSON(ResponseCode.SUCCESS, user);
//
//    }

//    返回页面示例，创建md5密码
    @RequestMapping(value = "/adminCreate")
    public ResponseJSON hello() {
        try {
            System.err.println(new Md5Hash("password", "12312312345", 3));
            System.err.println(new Md5Hash("password", "13602798934", 3));
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
//        return "helloword";
        return new ResponseJSON(ResponseCode.SUCCESS);
    }

//    发送验证短信
    @RequestMapping(value = "/sendMessage")
    public ResponseJSON sendMessage() throws Exception {
//        if (new sendSMS().send("13602800453")) {
//            return new ResponseJSON(ResponseCode.SUCCESS);
//        } else {
//            return new ResponseJSON(ResponseCode.UNKNOWNACCOUNT);
//        }
        Map result = IndustrySMS.execute("13602800453");
        String verficationCode = (String) result.get("verficationCode");
        String msg = (String) result.get("result");
        SecurityUtils.getSubject().getSession().setAttribute("verficationCode", verficationCode);
    //    String verficationCode = com.scau.hyskjf.util.sms.IndustrySMS.execute("13602800453");
   //     SecurityUtils.getSubject().getSession().setAttribute("verficationCode", verficationCode);
        return new ResponseJSON(ResponseCode.SUCCESS);
    }

    // 发送审核结果信息
    @RequestMapping(value = "/sendAuditNoPassSMS")
    public String sendAuditSMSNoPass() {
        String result = AuditSMS.nopass("13602800453", "supiccc", "Nike旗舰店");
        return result;
    }
    @RequestMapping(value = "/sendAuditPassSMS")
    public String sendAuditSMSPass() {
        try {
            String result = PassSMS.pass("13602800453", "supiccc", "Nike旗舰店",
                    "woaini");
            return result;
        } catch (Exception e) {
            return e.toString();
        }
    }

}
