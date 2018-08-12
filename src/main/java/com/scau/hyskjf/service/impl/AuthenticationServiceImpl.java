package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.AdminMapper;
import com.scau.hyskjf.dao.MemberaccountMapper;
import com.scau.hyskjf.dao.MerchantaccountMapper;
import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.service.AuthenticationService;
import com.scau.hyskjf.shiro.UsernamePasswordRoleToken;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by supiccc on 2018-08-10 11:31
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    MemberaccountMapper memberaccountMapper;

    @Autowired
    MerchantaccountMapper merchantaccountMapper;

    @Override
    public Memberaccount findBymaiid(String acc) {
        return memberaccountMapper.selectBymaid(acc);
    }

    @Override
    public Merchantaccount findMerchantByacc(String acc) {
        return merchantaccountMapper.selectByMacAcc(acc);
    }

    @Override
    public Admin findAdminByacc(String acc) {
        return adminMapper.selectByAcc(acc);
    }

    @Override
    public ResponseJSON login(String username, String pwd, String role) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordRoleToken token = new UsernamePasswordRoleToken(username, pwd.toCharArray(), role);
            subject.login(token);
            Object m = (Object) subject.getPrincipal();
            SecurityUtils.getSubject().getSession().setAttribute("user", m);
            SecurityUtils.getSubject().getSession().setAttribute("role", role);
            return new ResponseJSON(ResponseCode.SUCCESS, m);
        } catch (UnknownAccountException e) {
            return new ResponseJSON(ResponseCode.UNKNOWNACCOUNT);
        } catch (IncorrectCredentialsException e) {
            return new ResponseJSON(ResponseCode.INCORRECTPWD);
        }
    }
}
