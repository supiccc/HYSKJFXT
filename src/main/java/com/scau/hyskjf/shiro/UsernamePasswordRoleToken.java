package com.scau.hyskjf.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

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
}
