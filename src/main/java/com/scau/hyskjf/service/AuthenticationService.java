package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Memberaccount;

/**
 * Created by supiccc on 2018-08-10 11:31
 */
public interface AuthenticationService {
    // 通过账号查找会员信息
    Memberaccount findBymaiid(String id);

    // 通过账号查找商家信息

}
