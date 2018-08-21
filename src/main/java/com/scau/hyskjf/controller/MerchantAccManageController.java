package com.scau.hyskjf.controller;

import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.MerchantAccManageService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
* 商家账户管理：
* 使用者：商家管理员
* 功能：
* 1、商家添加子账号
* 2、子账号管理，查询账号信息，修改子账号的账号类型、密码、启用状态；
*    指定子账号的为会员充值权限（使用系统分配的根账号才能操作）
* */
@RestController
@RequestMapping("/merchantAccManage")
public class MerchantAccManageController {

    @Autowired
    MerchantAccManageService merchantAccManageService;
    /*（已测试）
    * 添加子账号：
    * 输入：
    * Merchantaccount类：
    * 商家编号Integer merid、登陆名（手机号码）String macacc、密码String macpasswd、
    * 账号类型Integer macacctype（11为管理员，2为前台账户，3为客户经理，14为部门经理,大于10的拥有为用户充值权限，管理员可为前台和客户经理添加充值权限，加权后数值为前台12和客户经理13）int、
    * 启用状态Boolean macenable、结账账户Integer maccumacc(一般不填)
    *
    * 返回：
    * 成功码或失败码
    * */
    @RequestMapping(value = "/addAffiliateAccount", method = RequestMethod.POST)
    public ResponseJSON addAffiliateAccount( Merchantaccount merchantaccount){
        try{
            merchantAccManageService.addMerchantAccount(merchantaccount);//插入到商家账户表
            return new ResponseJSON(ResponseCode.SUCCESS);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * (吕浩泰要求的接口)添加子账号：
     * 输入：
     * Merchantaccount类：
     * 商家编号Integer、登陆名（手机号码）String、密码String、
     * 账号类型（11为管理员，2为前台账户，3为客户经理，14为部门经理,大于10的拥有为用户充值权限，管理员可为前台和客户经理添加充值权限，加权后数值为前台12和客户经理13）int、
     * 启用状态Boolean、结账账户Integer
     *
     * 返回：
     * 商家ID对应的所有账号信息MerchantAccount类
     * */
    @RequestMapping(value = "/addAccountReturn", method = RequestMethod.POST)
    public ResponseJSON addAccountReturn(Merchantaccount merchantaccount){
        try{
            this.addAffiliateAccount(merchantaccount);
            List<Merchantaccount> accList = merchantAccManageService.queryMerchantAccountByMerID(merchantaccount.getMerid());
            return new ResponseJSON(ResponseCode.SUCCESS,accList);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
    * 查询整个系统所有商家账户：
    * 输入：
    * 无
    * 返回：
    * 所有商家账户表的信息
    * */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResponseJSON queryAll(){
        try{
            List<Merchantaccount> accList =merchantAccManageService.queryAllMerchantAccount();
            return new ResponseJSON(ResponseCode.SUCCESS,accList);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 查询某一商家所有账户（根据商家编号id查询）：
     * 输入：
     * 商家编号 Integer merid
     * 返回：
     * 商家编号对应商家的所有商家账户表的信息
     * */
    @RequestMapping(value = "/queryByMerID", method = RequestMethod.GET)
    public ResponseJSON queryByMerID(){
        try{
            Integer merid = ((Merchantaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMerid();
            List<Merchantaccount> accList =merchantAccManageService.queryMerchantAccountByMerID(merid);
            return new ResponseJSON(ResponseCode.SUCCESS,accList);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 根据登陆名查询账户（用户手机号）：
     * 输入：
     * 账户登陆名String macacc
     * 返回：
     * 账户登陆名对应账户信息
     * */
    @RequestMapping(value = "/queryByMacAcc", method = RequestMethod.POST)
    public ResponseJSON queryByMacAcc(String macacc){
        try{
            Merchantaccount acc =merchantAccManageService.queryMerchantAccountByMacAcc(macacc);
            return new ResponseJSON(ResponseCode.SUCCESS,acc);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 修改子账号密码(普通商家账号接口)
     * 输入：
     * 1、Merchantaccount类：必须有账户登录名macacc+原密码macpasswd
     * 2、新密码String newpwd
     * 返回：
     * 成功或失败码
     * */
    @RequestMapping(value = "/updatePwdByMacAcc", method = RequestMethod.POST)
    public ResponseJSON updatePwdByMacAcc(Merchantaccount merchantaccount,String newpwd){
        try{
            String uncheckedPwd = new Md5Hash(merchantaccount.getMacpasswd(),merchantaccount.getMacacc(),3).toString();//对用户输入账户的原密码进行MD5加密
            String newPwdMD5 = new Md5Hash(newpwd,merchantaccount.getMacacc(),3).toString();
            Merchantaccount acc =merchantAccManageService.queryMerchantAccountByMacAcc(merchantaccount.getMacacc());//从数据库获取登录名对应的账户实例
            String truePwd = acc.getMacpasswd();//获取正确的MD5密码
            if(truePwd.equals(uncheckedPwd)){//正确的MD5密码与输入的原密码MD5匹配，正确则执行更改密码
                acc.setMacpasswd(newPwdMD5);
                merchantAccManageService.updateMerchantAccount(acc);
                return new ResponseJSON(ResponseCode.SUCCESS);
            }
            else{
                return new ResponseJSON(ResponseCode.WARN,"输入的原密码不匹配");
            }
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 修改子账号密码(商家管理员账号接口)
     * 输入：
     * 1、Merchantaccount类：必须有账户登录名macAcc(原密码不需要)
     * 2、String 新密码
     * 返回：
     * 成功或失败码
     * */
    @RequestMapping(value = "/updateManagerPwdByMacAcc", method = RequestMethod.POST)
    public ResponseJSON updateManagerPwdByMacAcc(Merchantaccount merchantaccount,String newpwd){
        try{
            //String uncheckedPwd = new Md5Hash(merchantaccount.getMacpasswd(),merchantaccount.getMacacc(),3).toString();//对用户输入账户的原密码进行MD5加密
            Merchantaccount acc =merchantAccManageService.queryMerchantAccountByMacAcc(merchantaccount.getMacacc());//从数据库获取登录名对应的账户实例
            String newPwdMD5 = new Md5Hash(newpwd,merchantaccount.getMacacc(),3).toString();
            //String truePwd = acc.getMacpasswd();//获取正确的MD5密码
            //if(truePwd.equals(uncheckedPwd)){//正确的MD5密码与输入的原密码MD5匹配，正确则执行更改密码
            acc.setMacpasswd(newPwdMD5);
            merchantAccManageService.updateMerchantAccount(acc);
            return new ResponseJSON(ResponseCode.SUCCESS);
            //}
            //else{
            //    return new ResponseJSON(ResponseCode.WARN,new String("输入的原密码不匹配"));
            //}
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
    * 修改子账号的账号类型、启用状态
    * 输入：
    * Merchantaccount类：必须有账户编号macid+修改的项(登陆账号 String macacc;+结算账户（废弃） Integer maccumacc;+密码 String macpasswd;+账户类型 Integer macacctype;+上次登陆时间 Date maclastlogin;+是否启动 Boolean macenable;)
    * 返回：
    * 成功或失败码
    * */
    @RequestMapping(value = "/updateByMacID", method = RequestMethod.POST)
    public ResponseJSON updateByMacID(Merchantaccount merchantaccount){
        try{
            merchantaccount.setMacpasswd(null);//不能改密码
            merchantAccManageService.updateMerchantAccount(merchantaccount);
            return new ResponseJSON(ResponseCode.SUCCESS);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 删除子账号（实际操作只是把启用状态改为false）
     * 输入：
     * 账户编号macid
     * 返回：
     * 成功或失败码
     * */
    @RequestMapping(value = "/deleteByMacID", method = RequestMethod.POST)
    public ResponseJSON deleteByMacID(Merchantaccount merchantaccount){
        try{
            merchantaccount.setMacenable(false);
            merchantAccManageService.updateMerchantAccount(merchantaccount);
            return new ResponseJSON(ResponseCode.SUCCESS);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 为前台或客户经理添加充值权限（实际操作只是把账户类型+10）（只有macAccType==11的管理员账户才能操作）
     * 输入：
     * 账户登陆号（手机号）String macacc ,商家编号Integer merid
     * 返回：
     * 成功或失败码
     * */
    @RequestMapping(value = "/addPermission", method = RequestMethod.POST)
    public ResponseJSON addPermission(String macacc ,Integer merid){
        try{
                int i = merchantAccManageService.addPermissionByMacAcc(macacc ,merid);
                if(i==-1){
                    return new ResponseJSON(ResponseCode.WARN);
                }
                return new ResponseJSON(ResponseCode.SUCCESS);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*
    * 短信验证更改密码
    * 未写完
    * */
    //@RequestMapping(value = "/updatePwdByMassage", method = RequestMethod.POST)
    //public ResponseJSON updateMerchantAccountPwdByMassage(){
    //    return new ResponseJSON(ResponseCode.WARN);
    //
    //}

    /*（已测试）
     * 查询商家的没有分配客户经理的会员：
     * 输入：
     * 商家编号 Integer merid
     *
     * 输出：
     * 没有分配客户经理的会员 List<MemberMShow> list（包含属性：会员id Integer memid;+会员名字 String memname;+会员手机号 String memphone;）
     * */
    @RequestMapping(value = "/queryMember", method = RequestMethod.POST)
    public ResponseJSON queryMember(Integer merid){
        try{
            List<MemberMShow> list = merchantAccManageService.queryMemberByMerID(merid);
            return new ResponseJSON(ResponseCode.SUCCESS,list);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 查询商家的客户经理：
     * 输入：
     * 商家编号 Integer merid
     *
     * 输出：
     * 商家的客户经理 List<MManager> list（包含属性：客户经理账号id Integer macid;+商家编号id Integer merid;+ 客户经理账户登陆名（为手机号） String macacc;）
     * */
    @RequestMapping(value = "/queryMManager", method = RequestMethod.POST)
    public ResponseJSON queryMManager(Integer merid){
        try{
            List<MManager> list = merchantAccManageService.queryMemberManagerByMerID(merid);
            return new ResponseJSON(ResponseCode.SUCCESS,list);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
    * 指派客户经理：
    * 输入：
    * 会员编号 List<Integer> memberIDs ,客户经理的商家账户编号 Integer macid()
    *
    * 输出：
    * 正确码或错误码
    * */
    @RequestMapping(value = "/setMemberManager", method = RequestMethod.POST)
    public ResponseJSON setMemberManager(MemberModel memIDList , Integer macid){
        try{
            List<Integer> list = memIDList.getMemberIDs();
            List<Membermanager> mmList =new ArrayList<>();
            Membermanager membermanager = new Membermanager();
            membermanager.setMmatime(new Date());
            membermanager.setMmanagerid(macid);
            for(int i=0;i<list.size();i++){
                membermanager.setMemid(list.get(i));
                mmList.add(membermanager);
            }
            merchantAccManageService.setMemberManager(mmList);
            return new ResponseJSON(ResponseCode.SUCCESS);
        }catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }
}
