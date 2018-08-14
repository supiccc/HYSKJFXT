package com.scau.hyskjf.util.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by supiccc on 2018-08-10 11:45
 */
public class UsernamePasswordRoleToken extends UsernamePasswordToken {
    private String role;

    public UsernamePasswordRoleToken(String username, char[] password) {
        super(username, password);
    }

    public UsernamePasswordRoleToken(String username, char[] password, String role) {
        super(username, password);
        this.role = role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public char[] getPassword() {
        // 将取得的密码加密
        this.setPassword(new Md5Hash(super.getPassword(), super.getUsername(), 3).toString().toCharArray());
        return super.getPassword();
    }
}
