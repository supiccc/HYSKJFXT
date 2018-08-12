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

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        return new ResponseJSON(ResponseCode.SUCCESS, m);
    }

    // 发送验证码
    @RequestMapping(value = "/sendSMS")
    public ResponseJSON sendSMS() {
        String username = ((Memberaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMaid();
        String verficationCode = IndustrySMS.execute(username);
//        String verficationCode = VerficationCode.getCode();  // 获取验证码
        SecurityUtils.getSubject().getSession().setAttribute("verficationCode", verficationCode);
        return new ResponseJSON(ResponseCode.SUCCESS);
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
        Member m = memberCenterService.showMember();
        if (m == null) return new ResponseJSON(ResponseCode.WARN);
        return new ResponseJSON(ResponseCode.SUCCESS, m);
    }

    // 修改用户信息
    @RequestMapping(value = "/updateMember", method = RequestMethod.POST)
    public ResponseJSON updateMember(Member member, String birth, HttpSession session) throws ParseException {
        member.setMemid(((Memberaccount)session.getAttribute("user")).getMemid());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(birth);
        System.out.println(date);
        member.setMembirth(date);
        return new ResponseJSON(ResponseCode.SUCCESS, member);
    }
}
