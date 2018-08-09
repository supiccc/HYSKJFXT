package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Memberaccount;
import org.springframework.stereotype.Service;

/**
 * Created by supiccc on 2018-08-08 16:03
 */
public interface MemberCenterService {
    Memberaccount findBymaiid(int id); // 通过账号查找

}
