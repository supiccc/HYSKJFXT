package com.scau.hyskjf.shiro;

import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.service.MemberCenterService;
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
    MemberCenterService memberCenterService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    // 认证，登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken)authenticationToken; // 获取用户输入的token
        int maid = Integer.parseInt(utoken.getUsername());
        String password = utoken.getPassword().toString();
        Memberaccount member = memberCenterService.findBymaiid(maid);
        if (member == null) return null;
        return new SimpleAuthenticationInfo(member, member.getMapwd(), this.getClass().getName());
    }
}
