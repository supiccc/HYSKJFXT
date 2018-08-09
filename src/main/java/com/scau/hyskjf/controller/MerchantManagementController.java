package com.scau.hyskjf.controller;

import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MerchantManagementController {

    //商家查询，浏览联盟内商家，查询商家
    public ResponseJSON findAllMerchant(){
        return null;
    }

    //查看单个商家
    public ResponseJSON findMerchantById(){
        return null;
    }

    //查看所有账户信息
    public ResponseJSON findAllAccounts(){
        return null;
    }
    //查看单个账户信息
    public ResponseJSON findAccountById(){
        return null;
    }
    //禁用商家子账号
    public ResponseJSON forbidAccount(){
        return null;
    }
    //启用商家子账号
    public ResponseJSON enableAccount(){
        return null;
    }

    //禁用商家账号
    public ResponseJSON forbidMerchant(){
        return null;
    }
    //启用商家账号
    public ResponseJSON enableMerchant(){
        return null;
    }

    //积分划拨比列设置



    //
}
