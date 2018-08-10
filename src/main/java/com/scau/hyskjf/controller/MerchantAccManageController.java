package com.scau.hyskjf.controller;

import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.security.provider.MD5;

/*
* 商家账户管理：
* 使用者：商家管理员
* 功能：
* 1、商家添加子账号
* 2、子账号管理，查询账号信息，修改子账号的账号类型、密码、启用状态；
*    指定子账号的为会员充值权限（使用系统分配的根账号才能操作）
* */
@Controller
@RequestMapping("merchantAccManage")
public class MerchantAccManageController {
    /*
    * 添加子账号：
    * 输入：Merchantaccount类：商家编号Integer、登陆名String、密码String、账号类型int、启用状态Boolean
    * */
    @RequestMapping(value = "/addAffiliateAccount", method = RequestMethod.POST)
    public ResponseJSON addAffiliateAccount(Merchantaccount merchantaccount){
        String MD5pwd = DigestUtils.md5DigestAsHex(merchantaccount.getMacpasswd().getBytes());

        return new ResponseJSON(ResponseCode.SUCCESS, null);
    }
}
