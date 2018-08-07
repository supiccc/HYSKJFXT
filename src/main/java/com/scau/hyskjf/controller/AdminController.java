package com.scau.hyskjf.controller;

import com.scau.hyskjf.dao.AdminMapper;
import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.util.ResponseCode;
import com.scau.hyskjf.util.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by supiccc on 2018-08-07 17:11
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    @RequestMapping(value = "1000")
    @ResponseBody
    public ResponseJSON pic() {
//        调用dao层
        Admin user = adminMapper.selectByPrimaryKey(1000);
        return new ResponseJSON(ResponseCode.SUCCESS, user);
    }

}
