package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.util.json.ResponseJSON;

/**
 * Created by supiccc on 2018-08-10 11:31
 */
public interface AuthenticationService {
    // 通过账号查找会员信息
    Memberaccount findBymaiid(String acc);

    // 通过账号查找商家信息
    Merchantaccount findMerchantByacc(String acc);

    // 通过账号查找管理员信息
    Admin findAdminByacc(String acc);

    // 登录
    ResponseJSON login(String username, String pwd, String role, int rememberMe);

    // 忘记密码
    String forgetpwd(String username, String pwd, String vc, String role);
}