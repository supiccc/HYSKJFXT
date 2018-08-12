package com.scau.hyskjf.controller;

import com.scau.hyskjf.dao.MemberaccountMapper;
import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.service.MemberCenterService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import com.scau.hyskjf.util.sms.IndustrySMS;
import com.scau.hyskjf.util.sms.common.VerficationCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by supiccc on 2018-08-08 16:35
 */
@RestController
@RequestMapping("/memberCenter")
public class MemberCenterController {

    @Autowired
    MemberaccountMapper memberaccountMapper;

    @Autowired
    MemberCenterService memberCenterService;

    @RequestMapping(value = "/loginMember", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJSON login(String maid, String mapwd, HttpSession session) {
        UsernamePasswordToken token = new UsernamePasswordToken(maid, mapwd);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            Memberaccount m = (Memberaccount)subject.getPrincipal();
            session.setAttribute("user", m);
            return new ResponseJSON(ResponseCode.SUCCESS, m);
        } catch (UnknownAccountException e) {
            return new ResponseJSON(ResponseCode.UNKNOWNACCOUNT);
        } catch (IncorrectCredentialsException e) {
            return new ResponseJSON(ResponseCode.INCORRECTPWD);
        }
    }

    @RequestMapping(value = "/member")
    @ResponseBody
    public ResponseJSON getMember(HttpSession session) {
        Memberaccount m = (Memberaccount) session.getAttribute("user");
        return new ResponseJSON(ResponseCode.SUCCESS, m);
    }

    @RequestMapping(value = "/sendSMS")
    public ResponseJSON sendSMS() {
        String username = ((Memberaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMaid();
        String verficationCode = IndustrySMS.execute(username);
//        String verficationCode = VerficationCode.getCode();  // 获取验证码
        SecurityUtils.getSubject().getSession().setAttribute("verficationCode", verficationCode);
        return new ResponseJSON(ResponseCode.SUCCESS);
    }

    @RequestMapping(value = "/forgetLoginPassword")
    public ResponseJSON forgetLoginPassword(String newPassword, String verficationCode) {
        String result = memberCenterService.forgetPwd(newPassword, verficationCode);
        if (result.equals("true")) {
            return new ResponseJSON(ResponseCode.SUCCESS);
        } else {
            return new ResponseJSON(ResponseCode.WARN, result);
        }
    }
}
