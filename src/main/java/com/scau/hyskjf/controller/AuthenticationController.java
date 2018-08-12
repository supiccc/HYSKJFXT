package com.scau.hyskjf.controller;

import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.service.AuthenticationService;
import com.scau.hyskjf.shiro.UsernamePasswordRoleToken;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by supiccc on 2018-08-10 09:24
 * 认证、登录、注册控制器
 */
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseJSON login(String username, String pwd, String role) {
        ResponseJSON result = authenticationService.login(username, pwd, role);
        return result;
    }
}
