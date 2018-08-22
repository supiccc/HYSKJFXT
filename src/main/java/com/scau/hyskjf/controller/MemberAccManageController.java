package com.scau.hyskjf.controller;

import com.scau.hyskjf.dao.MemberMapper;
import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.MemberCenterService;
import com.scau.hyskjf.service.MerchantAccManageService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/*
* 3.1.1.4.3	商家会员管理
* 使用角色：商家账户
* 功能：
* （1）会员信息登记：商家对入会的会员进行基本信息登记,同时生成会员卡
* （2）会员基本信息变更：当会员基本信息有变化时，发卡商家可以对该会员的基本信息进行维护和变更。
* （3）为会员账户添加会员卡
* */
@SessionAttributes("user")
@RestController
@RequestMapping("/memberAcc")
public class MemberAccManageController {

    @Autowired
    MemberCenterService memberCenterService;

    @Autowired
    MemberMapper memberMapper;

    /*
    * 添加会员账户(已测试)
    * 输入：
    * 会员信息Member member：（ 证件类型 String memcer;+ 证件号 String memcerid;+ 姓名 String memname（必填）;
    * +性别 String memsex;+ 生日 Date membirth;+ 手机号 String memphone（必填）;+ 邮箱 String mememail;+ 地址 String memadress; ）
    * 密码String pwd,支付密码String shopPwd
    *
    * 返回：
    * 成功码或失败码
    * */
    @RequestMapping("/addAcc")
    public ResponseJSON addAcc(Member member,String pwd,String shoppwd){
        try{
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = formatter.parse(birth);
//            member.setMembirth(date);
            memberCenterService.addMemberAccount(member,pwd,shoppwd);//往memberMapper添加信息再往memberAccountMapper添加信息
            return new ResponseJSON(ResponseCode.SUCCESS);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 为会员添加会员卡(20180815 21：37 会员卡卡号生成严重影响性能，修改生成规则为商家编号11位+会员编号11位)
     * 输入：
     * 会员手机号 String memphone + 商家编号 Integer merid; +是否启用 Boolean mcenable;
     *
     * 返回：
     * 成功：
     * 会员卡卡号String cardNum
     * 失败：
     * 会员未创建或手机号未填写返回失败码-1
     * */
    @RequestMapping("/addMemCard")
    public ResponseJSON addMemCard(String memphone,Boolean mcenable){
        try{
            Integer merid = ((Merchantaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMerid();
            Integer memID = memberMapper.queryMemIDByMemphone(memphone);//通过手机号查找memID
            if(memID==null){
                throw new Exception();
            }
            Membercard membercard = new Membercard();
            membercard.setMemid(memID);
            membercard.setMerid(merid);
            membercard.setMcbalance((float) 0);
            membercard.setMcenable(true);
            String  cardNum = memberCenterService.addMemberCard(membercard);
            return new ResponseJSON(ResponseCode.SUCCESS,cardNum);
        }
        catch (Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 查看商家发放的所有会员卡
     * 输入：
     * 商家编号 Integer merid;
     *
     * 返回：
     * 会员卡类列表List<Membercard>
     * Membercard包含属性：（会员卡表的主键ID Integer mcpkid;+会员号 Integer memid;+会员卡卡号 String mcid;+商家编号 Integer merid;+会员卡类型（已废弃） String mctype;
                            会员卡剩余积分（已废弃） Float mccredit;+会员卡剩余储值 Float mcbalance;+会员卡是否启用 Boolean mcenable;）
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

    /*（已测试）
     * 根据会员卡卡号String mcid查询会员卡信息
     * 输入：
     * 会员卡卡号String mcid
     *
     * 返回：
     * 会员卡类Membercard membercard（包含属性同上）
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

    /*（已测试）
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




    //根据会员卡卡号查询会员详细信息
    @RequestMapping("/queryMemdetailByMcid")
    public ResponseJSON queryMemberDetailByCardId(String cardId){
        Memberandcard memberandcard = memberCenterService.findMemDetailByCarId(cardId);
        return new ResponseJSON(ResponseCode.SUCCESS,memberandcard);
    }

    //会员充值
    @RequestMapping("/recharge")
    public ResponseJSON rechargeMemberCard(@ModelAttribute("user") Merchantaccount merchantaccount, String cardId, Float money){
        CreditConsumption record = memberCenterService.rechargeMemberCard(cardId,money,merchantaccount);
        if(record.getCheckResult().equals(0)){
            return new ResponseJSON(ResponseCode.SUCCESS);
        }else if(record.getCheckResult().equals(-2)){
            return new ResponseJSON(ResponseCode.ERRORCARD);
        } else{
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    //会员充值历史查询
    //按会员卡，由于一个会员的充值次数不会很多，就显示全部信息，按时间倒序排序
    @RequestMapping("/queryRecharge")
    public ResponseJSON queryRechargeHistory(String cardId){
        List<Rechargehistory> rechargehistories = memberCenterService.findRechargeHistoryByCardId(cardId);
        return new ResponseJSON(ResponseCode.SUCCESS,rechargehistories);
    }


    //查询本商家的所有充值记录、 按一天内、一星期内、一个月内、全部
    @RequestMapping("/queryAllRecharge")
    public ResponseJSON queryAllRechargeHistory(@ModelAttribute("user") Merchantaccount merchantaccount){
        List<Rechargehistory> rechargehistories = memberCenterService.findAllRechargeHistory(merchantaccount.getMerid());
        return new ResponseJSON(ResponseCode.SUCCESS,rechargehistories);
    }
}
