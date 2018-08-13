package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.CredithistoryviewMapper;
import com.scau.hyskjf.dao.MemberMapper;
import com.scau.hyskjf.dao.MemberaccountMapper;
import com.scau.hyskjf.pojo.Credithistoryview;
import com.scau.hyskjf.pojo.Member;
import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.service.MemberCenterService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by supiccc on 2018-08-09 08:53
 */
@Service
public class MemberCenterServiceImpl implements MemberCenterService {
    @Autowired
    MemberaccountMapper memberaccountMapper;

    @Autowired
    CredithistoryviewMapper credithistoryviewMapper;

    @Autowired
    MemberMapper memberMapper;

    @Override
    public String forgetPwd(String newPwd, String verficationCode) {
        try {
            if (SecurityUtils.getSubject().getSession().getAttribute("verficationCode").toString().equals(verficationCode)) {
                Memberaccount tmp = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
                Memberaccount m = memberaccountMapper.selectByPrimaryKey(tmp.getMemid());
                m.setMapwd((new Md5Hash(newPwd, m.getMaid(), 3).toString()));
                memberaccountMapper.updateByPrimaryKey(m);
                return "TRUE";
            } else {
                return "INCORRECT VERFICATION CODE";
            }
        } catch (Exception e) {
            return e.toString();
        }
    }

    @Override
    public String forgetDealPwd(String oldPwd, String newPwd) {
        try {
            Memberaccount tmp = (Memberaccount)SecurityUtils.getSubject().getSession().getAttribute("user");
            Memberaccount m = memberaccountMapper.selectByPrimaryKey(tmp.getMemid());
            if (m.getMacumpwd().equals(new Md5Hash(oldPwd, m.getMaid(), 3).toString())) {
                m.setMacumpwd((new Md5Hash(newPwd, m.getMaid(), 3).toString()));
                memberaccountMapper.updateByPrimaryKey(m);
                return "TRUE";
            } else {
                return "INCORRECT OLD PASSWORD";
            }
        } catch (Exception e) {
            return e.toString();
        }
    }

    // 显示会员信息
    @Override
    public Map showMember() {
        Memberaccount tmp = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
        Member m = memberMapper.selectByPrimaryKey(tmp.getMemid());
        if (m == null) return null;
        Map result = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(m.getMembirth());
        m.setMembirth(null);
        result.put("Object", m);
        result.put("birth", date);
        return result;
    }

    // 显示积分变动历史
    @Override
    public List<Credithistoryview> showCreditHistory() {
        Memberaccount m = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
        if (m == null) return null;
        return credithistoryviewMapper.selectAll(m.getMemid());
    }


    // 更新会员信息
    @Override
    public Map<String, Object> updateMember(Member member, String birth) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(birth);
        member.setMembirth(date);
        memberMapper.updateByPrimaryKeySelective(member);
        member.setMembirth(null);
        Map<String, Object> result = new HashMap<>();
        result.put("Object", member);
        result.put("Birth", birth);
        return result;
    }
}
