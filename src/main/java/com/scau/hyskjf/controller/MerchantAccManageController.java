package com.scau.hyskjf.controller;

import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("merchantAccManage")
public class MerchantAccManageController {
    @RequestMapping(value = "/addAffiliateAccount", method = RequestMethod.POST)
    public ResponseJSON addAffiliateAccount(){
        return new ResponseJSON(ResponseCode.SUCCESS, null);
    }
}
