package com.scau.hyskjf.controller;

import com.scau.hyskjf.dao.AdminMapper;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by supiccc on 2018-08-07 17:11
 */

//@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminMapper adminMapper;
//
    @ResponseBody
    @RequestMapping(value = "/1000")
    public ResponseJSON pic() {
        //调用dao层
      //  Admin user = adminMapper.selectByPrimaryKey(1000);
        return new ResponseJSON(ResponseCode.SUCCESS, "hehe");

    }
    @RequestMapping(value = "/hello")
    public String hello() {
        return "helloword";
    }

}
