package com.scau.hyskjf.service;

import org.springframework.stereotype.Service;

/**
 * Created by supiccc on 2018-08-08 16:03
 */
@Service
public interface MemberCenterService {
    Memberaccount findBymaiid(int id); // 通过账号查找
}
