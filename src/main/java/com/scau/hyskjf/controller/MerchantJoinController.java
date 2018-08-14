package com.scau.hyskjf.controller;

import com.scau.hyskjf.pojo.Merchant;
import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.pojo.Merchantinfo;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;
import com.scau.hyskjf.service.MerchantJoinService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
* 3.1.1.3加盟管理模块
* 使用者：商家管理员
* 功能：
* 1、独立商家加盟（没有上级）
* 2、发展商家加盟（有上级）
* 3、同系统会员消费统计
* 4、入盟商家问题反馈(可移到其他控制类)
* */
@RestController
@RequestMapping("/merchantJoin")
public class MerchantJoinController {
    @Autowired
    MerchantJoinService merchantJoinService;

    /*
     * 独立商家加盟（没有上级）：
     * 输入：
     * 商家资料MerchantInfo类：
     * （ 商家头像图片String merimage + 是否为主图片 Boolean mermainimage + 联系电话 String mertelphone; +
     * 传真 String merfax; + 网址 String merurl; + 电子邮箱 String meremail; + 联系人 String merprincipal; +
     * 称谓 String merappellation; + 职务 String merduty; + 手机 String merphone; + 星级 Integer merlevel; +
     * 邮编 String merpostnum; + 所在省份 String merprovince; + 所在城市 String mercity; + 所在区县 String merarea +
     * 商家介绍 String merintroduce + 联系地址 String meradress + 附件地标 String merlandmark + 会员特惠 String merdiscount +
     * 促销活动 String merdiscountevent;。 ）
     * 商家Merchant类：
     * （ 父编号 Integer mersubid(不用填，为null) + 顶级编号 Integer mertopid(已废弃)+ 商家类型 String mertype + 商家名称 String mername
     * +消费积分比例 Float mercumpresent + 会员折扣比例 Float merdicpresent + 入盟申请状态 Boolean merappstat+
     * 是否推荐商家 Boolean merrecommend + 是否显示在首页 Boolean isindex + 所欠积分Boolean isindex）
     * 返回：
     * 成功码或失败码
     * */
    @RequestMapping(value = "/independentJoin", method = RequestMethod.POST)
    public ResponseJSON independentJoin(MerchantinfoWithBLOBs merchantinfoWithBLOBs, Merchant merchant){
        try{
            merchantJoinService.independentJoin(merchantinfoWithBLOBs,merchant);
            return new ResponseJSON(ResponseCode.SUCCESS);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*
     * 发展商家加盟（有上级）：
     * 输入：
     * 商家资料MerchantInfo类：
     * （ 商家头像图片String merimage + 是否为主图片 Boolean mermainimage + 联系电话 String mertelphone; +
     * 传真 String merfax; + 网址 String merurl; + 电子邮箱 String meremail; + 联系人 String merprincipal; +
     * 称谓 String merappellation; + 职务 String merduty; + 手机 String merphone; + 星级 Integer merlevel; +
     * 邮编 String merpostnum; + 所在省份 String merprovince; + 所在城市 String mercity; + 所在区县 String merarea +
     * 商家介绍 String merintroduce + 联系地址 String meradress + 附件地标 String merlandmark + 会员特惠 String merdiscount +
     * 促销活动 String merdiscountevent;。 ）
     * 商家Merchant类：
     * （ 父编号 Integer mersubid(必须有) + 顶级编号 Integer mertopid(已废弃)+ 商家类型 String mertype + 商家名称 String mername
     * +消费积分比例 Float mercumpresent + 会员折扣比例 Float merdicpresent + 入盟申请状态 Boolean merappstat+
     * 是否推荐商家 Boolean merrecommend + 是否显示在首页 Boolean isindex + 所欠积分Boolean isindex）
     * 返回：
     * 成功码或失败码
     * */
    @RequestMapping(value = "/developJoin", method = RequestMethod.POST)
    public ResponseJSON developJoin(MerchantinfoWithBLOBs merchantinfoWithBLOBs, Merchant merchant){
        try{
            merchantJoinService.developJoin(merchantinfoWithBLOBs,merchant);
            return new ResponseJSON(ResponseCode.SUCCESS);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

}