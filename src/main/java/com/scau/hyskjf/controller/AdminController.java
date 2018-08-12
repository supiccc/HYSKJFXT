package com.scau.hyskjf.controller;

import com.scau.hyskjf.dao.AdminMapper;
import com.scau.hyskjf.dao.MemberaccountMapper;
import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Memberaccount;
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

    @Autowired
    MemberaccountMapper memberaccountMapper;
//
    @ResponseBody
    @RequestMapping(value = "/1000")
    public ResponseJSON pic() {
        //调用dao层
        Admin user = adminMapper.selectByAcc("13602800453");
        return new ResponseJSON(ResponseCode.SUCCESS, user);

    }
    @RequestMapping(value = "/hello")
    public String hello() {
        return "helloword";
    }

}
