package com.scau.hyskjf.controller;

import com.scau.hyskjf.dao.MemberMapper;
import com.scau.hyskjf.dao.MerchantMapper;
import com.scau.hyskjf.pojo.Member;
import com.scau.hyskjf.pojo.Membercard;
import com.scau.hyskjf.pojo.Memberinfochange;
import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.service.MemberCenterService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
* 3.1.1.4.3	商家会员管理
* 使用角色：商家账户
* 功能：
* （1）会员信息登记：商家对入会的会员进行基本信息登记,同时生成会员卡
* （2）会员基本信息变更：当会员基本信息有变化时，发卡商家可以对该会员的基本信息进行维护和变更。
* （3）为会员账户添加会员卡
* */
@RestController
@RequestMapping("/memberAcc")
public class MemberAccManageController {

    @Autowired
    MemberCenterService memberCenterService;

    @Autowired
    MemberMapper memberMapper;
    /*
    * 添加会员账户
    * 输入：
    * 会员信息Member member：（ 证件类型 String memcer;+ 证件号 String memcerid;+ 姓名 String memname（必填）;
    * +性别 String memsex;+ 生日 Date membirth;+ 手机号 String memphone（必填）;+ 邮箱 String mememail;+ 地址 String memadress; ）
    * 密码String pwd,支付密码String shopPwd
    *
    * 返回：
    * 成功码或失败码
    * */
    @RequestMapping("/addAcc")
    public ResponseJSON addAcc(Member member,String pwd,String shopPwd){
        try{
            memberCenterService.addMemberAccount(member,pwd,shopPwd);//往memberMapper添加信息再往memberAccountMapper添加信息
            return new ResponseJSON(ResponseCode.SUCCESS);
        }
        catch (Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*
     * 为会员添加会员卡(20180815 21：37 会员卡卡号生成严重影响性能，修改生成规则为商家编号11位+会员编号11位)
     * 输入：
     * 会员卡信息MemberCard membercard：（ 会员号 Integer memid;+ 商家编号 Integer merid; +是否启用 Boolean mcenable;）
     *
     * 返回：
     * 会员卡卡号String cardNum
     * */
    @RequestMapping("/addMemCard")
    public ResponseJSON addMemCard(Membercard membercard){
        try{
            if(!memberMapper.selectByPrimaryKey(membercard.getMemid()).getMemphone().isEmpty()){
                String  cardNum = memberCenterService.addMemberCard(membercard);
                return new ResponseJSON(ResponseCode.SUCCESS,cardNum);
            }
            else {
                return new ResponseJSON(ResponseCode.WARN);
            }
        }
        catch (Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*
     * 查看商家发放的所有会员卡
     * 输入：
     * 商家编号 Integer merid;
     *
     * 返回：
     * 会员卡类列表List<Membercard>
     * */
    @RequestMapping("/queryAllMemCard")
    public ResponseJSON queryAllMemCard(Integer merid){
        try{
            List<Membercard> list = memberCenterService.queryAllMemCard(merid);
            return new ResponseJSON(ResponseCode.SUCCESS,list);
        }
        catch (Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*
     * 根据会员卡卡号String mcid查询会员卡信息
     * 输入：
     * 会员卡卡号String mcid
     *
     * 返回：
     * 会员卡类Membercard membercard
     * */
    @RequestMapping("/queryCardByMcid")
    public ResponseJSON queryCardByMcid(String mcid){
        try{
            Membercard membercard = memberCenterService.queryCardByMcid(mcid);
            return new ResponseJSON(ResponseCode.SUCCESS,membercard);
        }
        catch (Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*
    * 会员卡基本信息变更:（会员卡主键id必填，主键id调用以上两个查询接口可获得，其他信息不需要修改则不用填）
    * 输入：
    * 会员卡类Membercard membercard：（会员卡主键id Integer mcpkid;（必填）+ 会员卡类 String mctype;或 积分 Float mccredit 或 余额 Float mcbalance;或 是否启用 Boolean mcenable;）
    * 输出：
    * 成功码或失败码
    * */
    @RequestMapping("/updateCard")
    public ResponseJSON updateCard(Membercard membercard){
        try{
            memberCenterService.updateCard(membercard);
            return new ResponseJSON(ResponseCode.SUCCESS);
        }
        catch (Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

}
