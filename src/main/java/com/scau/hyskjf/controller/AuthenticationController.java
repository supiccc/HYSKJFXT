package com.scau.hyskjf.controller;

import com.scau.hyskjf.service.AuthenticationService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import com.scau.hyskjf.util.sms.IndustrySMS;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by supiccc on 2018-08-10 09:24
 * 认证、登录、注册控制器
 */
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseJSON login(String username, String pwd, String role, int rememberMe) {
        ResponseJSON result = authenticationService.login(username, pwd, role, rememberMe);
        return result;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseJSON checkout() {
//        Object o = SecurityUtils.getSubject().getSession().getAttribute("user");
        return new ResponseJSON(ResponseCode.SUCCESS, SecurityUtils.getSubject().getSession().getAttribute("role"));
    }


    /*忘记密码下发送验证码
     **发送验证码并将生成验证码放入session中的verficationCode
     * */
    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
    public ResponseJSON sendSMS(String username) {
//        String username = ((Memberaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMaid();
        Map result = IndustrySMS.execute(username);
        String verficationCode = (String) result.get("verficationCode");
        String msg = (String) result.get("result");
//        String verficationCode = VerficationCode.getCode();  // 获取验证码
        SecurityUtils.getSubject().getSession().setAttribute("verficationCode", verficationCode);
        return new ResponseJSON(ResponseCode.SUCCESS, msg);
    }


    /*
    * 忘记密码
    * 传入数据：用户名，新密码，验证码
    * */
    @RequestMapping(value = "/forget", method = RequestMethod.POST)
    public ResponseJSON forgetpwd(String username, String pwd, String vc, String role) {
        String result = authenticationService.forgetpwd(username, pwd, vc, role);
        if (result.equals("success")) {
            return new ResponseJSON(ResponseCode.SUCCESS);
        } else if (result.equals("incorrectcode")) {
            return new ResponseJSON(ResponseCode.WARN, "验证码错误");
        } else if (result.equals("incorrectrole")) {
            return new ResponseJSON(ResponseCode.WARN, "角色错误");
        }
        return new ResponseJSON(ResponseCode.WARN, "服务器未知错误");
    }

    @RequestMapping(value = "/logout")
    public ResponseJSON logout() {
        SecurityUtils.getSubject().logout();
        return new ResponseJSON(ResponseCode.SUCCESS);
    }

}
