package com.scau.hyskjf.util.shiro;

import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.service.AuthenticationService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by supiccc on 2018-08-09 08:42
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    AuthenticationService authenticationService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    // 认证，登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordRoleToken utoken = (UsernamePasswordRoleToken)authenticationToken; // 获取用户输入的token
        String username = utoken.getUsername();
        String role = utoken.getRole();
        if (role.equals("admin")) {
            Admin user = authenticationService.findAdminByacc(username);
            if (user == null) return null;
            return new SimpleAuthenticationInfo(user, user.getAdminpwd(), this.getClass().getName());
        } else if (role.equals("member")) {
            Memberaccount user = authenticationService.findBymaiid(username);
            if (user == null) return null;
            return new SimpleAuthenticationInfo(user, user.getMapwd(), this.getClass().getName());
        } else if (role.equals("merchant")) {
            Merchantaccount user = authenticationService.findMerchantByacc(username);
            if (user == null) return null;
            return new SimpleAuthenticationInfo(user, user.getMacpasswd(), this.getClass().getName());
        }
        return null;
    }
}
