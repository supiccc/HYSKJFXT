package com.scau.hyskjf.controller;

import com.scau.hyskjf.service.RedisService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by supiccc on 2018-08-13 23:01
 */
@RestController
@RequestMapping("/restful")
public class RestfulController {
    @Autowired
    private RedisService redisService;
    @RequestMapping(value = "/stu", method = RequestMethod.GET)
    public ResponseJSON say() {
        String mes = "获取信息";
        return new ResponseJSON(ResponseCode.SUCCESS, mes);
    }

    @RequestMapping(value = "/stu", method = RequestMethod.POST)
    public ResponseJSON say(String a) {
        String mes = "修改信息";
        redisService.set("a", a, 2);
        return new ResponseJSON(ResponseCode.SUCCESS, redisService.get("a"));
    }
}
