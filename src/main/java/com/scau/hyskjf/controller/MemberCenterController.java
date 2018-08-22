package com.scau.hyskjf.controller;

import com.scau.hyskjf.dao.MemberaccountMapper;
import com.scau.hyskjf.pojo.Credithistoryview;
import com.scau.hyskjf.pojo.Member;
import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.service.MemberCenterService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import com.scau.hyskjf.util.sms.IndustrySMS;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by supiccc on 2018-08-08 16:35
 * 会员中心控制器
 */
@RestController
@RequestMapping("/memberCenter")
public class MemberCenterController {

    @Autowired
    MemberaccountMapper memberaccountMapper;

    @Autowired
    MemberCenterService memberCenterService;

    @RequestMapping(value = "/member")
    @ResponseBody
    public ResponseJSON getMember(HttpSession session) {
        Memberaccount m = (Memberaccount) session.getAttribute("user");
        return new ResponseJSON(ResponseCode.SUCCESS, SecurityUtils.getSubject().getSession().getAttribute("role"));
    }

    /*用户已登录情况下发送验证码
    **发送验证码并将生成验证码放入session中的verficationCode
    * */
    @RequestMapping(value = "/sendSMS")
    public ResponseJSON sendSMS() {
        String username = ((Memberaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMaid();
        Map result = IndustrySMS.execute(username);
        String verficationCode = (String) result.get("verficationCode");
        String msg = (String) result.get("result");
//        String verficationCode = VerficationCode.getCode();  // 获取验证码
        SecurityUtils.getSubject().getSession().setAttribute("verficationCode", verficationCode);
        return new ResponseJSON(ResponseCode.SUCCESS, msg);
    }


    // 修改登录密码
    @RequestMapping(value = "/forgetLoginPassword", method = RequestMethod.POST)
    public ResponseJSON forgetLoginPassword(String newPassword, String verficationCode) {
        String result = memberCenterService.forgetPwd(newPassword, verficationCode);
        if (result.equals("TRUE")) {
            return new ResponseJSON(ResponseCode.SUCCESS);
        } else {
            return new ResponseJSON(ResponseCode.WARN, result);
        }
    }

    // 修改消费密码
    @RequestMapping(value = "/forgetCumPassword", method = RequestMethod.POST)
    public ResponseJSON forgetDealPassword(String oldPassword, String newPassword) {
        String result = memberCenterService.forgetDealPwd(oldPassword, newPassword);
        if (result.equals("TRUE")) {
            return new ResponseJSON(ResponseCode.SUCCESS);
        } else {
            return new ResponseJSON(ResponseCode.WARN, result);
        }
    }

    // 查询个人积分历史
    @RequestMapping(value = "/ShowCreditHistory", method = RequestMethod.GET)
    public ResponseJSON CreditHistory() {
        List<Credithistoryview> credithistory = memberCenterService.showCreditHistory();
        return new ResponseJSON(ResponseCode.SUCCESS, credithistory);
    }

    // 查询用户信息
    @RequestMapping(value = "/showMember", method = RequestMethod.GET)
    public ResponseJSON showMember() {
        Map m = memberCenterService.showMember();
        if (m == null) return new ResponseJSON(ResponseCode.WARN);
        return new ResponseJSON(ResponseCode.SUCCESS, m);
    }

    // 修改用户信息
    @RequestMapping(value = "/updateMember", method = RequestMethod.POST)
    public ResponseJSON updateMember(Member member, String birth, HttpSession session) {
        member.setMemid(((Memberaccount)session.getAttribute("user")).getMemid());
        try {
            Map result = memberCenterService.updateMember(member, birth);
            return new ResponseJSON(ResponseCode.SUCCESS, result);
        } catch (ParseException e) {
            return new ResponseJSON(ResponseCode.ILLEGALCODE, e.toString());
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    // 显示消费记录
    @RequestMapping(value = "/showConsume", method = RequestMethod.GET)
    public ResponseJSON showConsume() {
        List result = memberCenterService.showConsumedetail();
        if (result == null) return new ResponseJSON(ResponseCode.WARN);
        return new ResponseJSON(ResponseCode.SUCCESS, result);
    }

    // 显示未点评消费记录
//    @RequestMapping(value = "/showNOTComment", method = RequestMethod.GET)
//    public ResponseJSON showNotComment() {
//        List result = memberCenterService.showNoComment();
//        if (SecurityUtils.getSubject().getSession().getAttribute("user") == null) return new ResponseJSON(ResponseCode.NOTLOGIN);
//        return new ResponseJSON(ResponseCode.SUCCESS, result);
//    }

    /* 进行点评
    ** 请求：消费记录编号
    */
    @RequestMapping(value = "/comment/{merID}", method = RequestMethod.POST)
    public ResponseJSON doComment(@PathVariable Integer merID, String info, HttpServletRequest request) {
        String result = memberCenterService.comment(merID, info, request);
        if (result.equals("success")) {
            return new ResponseJSON(ResponseCode.SUCCESS);
        } else if (result.equals("nologin")) {
            return new ResponseJSON(ResponseCode.NOTLOGIN, "请先登录");
        } else if (result.equals("noconsume")) {
            return new ResponseJSON(ResponseCode.WARN, "您还未在本店消费");
        } else if (result.equals("hascomment")){
            return new ResponseJSON(ResponseCode.WARN, "您已点评过本店啦");
        } else {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*
    * 显示用户所持有的会员卡
    * */
    @RequestMapping("/showMemberCard")
    public ResponseJSON showmembercard() {
        try {
            List result = memberCenterService.showMemberCardInfo();
            return new ResponseJSON(ResponseCode.SUCCESS, result);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN, e.toString());
        }
    }
}
