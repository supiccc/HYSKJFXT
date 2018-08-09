package com.scau.hyskjf.controller;

import com.scau.hyskjf.dao.MemberaccountMapper;
import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by supiccc on 2018-08-08 16:35
 */
@Controller
public class MemberCenterController {

    @Autowired
    MemberaccountMapper memberaccountMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJSON login(int id) {
        Memberaccount m = memberaccountMapper.selectByPrimaryKey(id);
        if (m != null) {
            return new ResponseJSON(ResponseCode.SUCCESS, m);
        } else {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

}
