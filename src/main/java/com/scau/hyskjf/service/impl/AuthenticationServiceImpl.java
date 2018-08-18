package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.AdminMapper;
import com.scau.hyskjf.dao.MemberaccountMapper;
import com.scau.hyskjf.dao.MerchantaccountMapper;
import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.AuthenticationService;
import com.scau.hyskjf.util.shiro.UsernamePasswordRoleToken;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
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
    public ResponseJSON login(String username, String pwd, String role, int rememberMe) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordRoleToken token = new UsernamePasswordRoleToken(username, pwd.toCharArray(), role);
            if (rememberMe == 1) {
                token.setRememberMe(true);
            }
            subject.login(token);
            Object m = (Object) subject.getPrincipal();
            if (role.equals("admin")) {
                ((Admin) m).setAdminpwd(null);
            } else if (role.equals("member")) {
                ((Memberaccount) m).setMapwd(null);
                ((Memberaccount) m).setMacumpwd(null);
            } else if (role.equals("merchant")) {
                ((Merchantaccount) m).setMacpasswd(null);
            }
            SecurityUtils.getSubject().getSession().setAttribute("user", m);
            SecurityUtils.getSubject().getSession().setAttribute("role", role);
            return new ResponseJSON(ResponseCode.SUCCESS, m);
        } catch (UnknownAccountException e) {
            return new ResponseJSON(ResponseCode.UNKNOWNACCOUNT);
        } catch (IncorrectCredentialsException e) {
            return new ResponseJSON(ResponseCode.INCORRECTPWD);
        }
    }

    @Override
    public String forgetpwd(String username, String pwd, String vc, String role) {
        try {
            String vcode = (String) SecurityUtils.getSubject().getSession().getAttribute("verficationCode");
            if (vc.equals(vcode)) {
                pwd = new Md5Hash(pwd, username, 3).toString();
                if (role.equals("member")) {
                    Memberaccount m = memberaccountMapper.selectBymaid(username);
                    m.setMapwd(pwd);
                    memberaccountMapper.updateByPrimaryKey(m);
                    return "success";
                } else if (role.equals("merchant")) {
                    Merchantaccount m = merchantaccountMapper.selectByMacAcc(username);
                    m.setMacpasswd(pwd);
                    merchantaccountMapper.updateByPrimaryKey(m);
                    return "success";
                } else if (role.equals("admin")) {
                    Admin admin = adminMapper.selectByAcc(username);
                    admin.setAdminpwd(pwd);
                    adminMapper.updateByPrimaryKey(admin);
                    return "success";
                } else return "incorrectrole";
            } else {
                return "incorrectcode";
            }
        } catch (Exception e) {
            return e.toString();
        }
    }
}
