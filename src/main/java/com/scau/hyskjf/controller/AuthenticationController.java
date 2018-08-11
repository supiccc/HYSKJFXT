package com.scau.hyskjf.controller;

import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by supiccc on 2018-08-10 09:24
 * 认证、登录、注册控制器
 */
@RestController
public class AuthenticationController {

    @RequestMapping(value = "/logina", method = RequestMethod.POST)
    public ResponseJSON login() {
        return new ResponseJSON(ResponseCode.SUCCESS);
    }
}
