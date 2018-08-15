package com.scau.hyskjf.controller;

import com.scau.hyskjf.service.MerchantExhibitionService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by supiccc on 2018-08-14 20:16
 */
@RestController
public class MerchantExhibitionController {

    @Autowired
    MerchantExhibitionService merchantExhibitionService;

    /*
    * 返回所有商家merID、merImage、merIntroduce、merAddress、merTelephone、merPrincipal、merProvince、merCity、
    * merArea、merFax、merType
    * */
    @RequestMapping(value = "/getallmerchant", method = RequestMethod.GET)
    public ResponseJSON getAllMerchant() {
        return new ResponseJSON(ResponseCode.SUCCESS, merchantExhibitionService.getAll());
    }

    /*
    * 输入商家merID
    * 返回商家基本信息、产品、评论信息
    * */
    @RequestMapping(value = "/getmerchant/{merID}", method = RequestMethod.GET)
    public ResponseJSON getMerchantInfo(@PathVariable Integer merID) {
        Map result = merchantExhibitionService.doget(merID);
        return new ResponseJSON(ResponseCode.SUCCESS, result);
    }

}
