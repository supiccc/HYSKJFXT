package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Memberaccount;

/**
 * Created by supiccc on 2018-08-08 16:03
 */
public interface MemberCenterService {
    Memberaccount findBymaiid(String id); // 通过账号查找

}
