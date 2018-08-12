package com.scau.hyskjf.controller;

import com.scau.hyskjf.service.MerchantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 3.1.1.1.4	商家展示信息维护功能模块
* 使用角色：管理员
* （1）商家资料维护MerchantInfo表
* （2）产品维护ProductInfo表
* */

@RestController
@RequestMapping("/merchantInfo")
public class MerchantInfoController {
    @Autowired
    MerchantInfoService merchantInfoService;

    
}
