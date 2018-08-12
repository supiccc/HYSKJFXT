package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.CredithistoryviewMapper;
import com.scau.hyskjf.dao.MemberaccountMapper;
import com.scau.hyskjf.pojo.Credithistoryview;
import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.pojo.Merchant;
import com.scau.hyskjf.service.MemberCenterService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * Created by supiccc on 2018-08-09 08:53
 */
@Service
public class MemberCenterServiceImpl implements MemberCenterService {
    @Autowired
    MemberaccountMapper memberaccountMapper;

    @Autowired
    CredithistoryviewMapper credithistoryviewMapper;

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

    @Override
    public List<Credithistoryview> showCreditHistory() {
        Memberaccount m = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
        if (m == null) return null;
        return credithistoryviewMapper.selectAll(m.getMemid());
    }
}
