package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.service.MemberCenterService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by supiccc on 2018-08-09 08:53
 */
public class MemberCenterServiceImpl implements MemberCenterService {
    @Autowired
    MemberaccountMapper memberaccountMapper;

    // 通过账号查找
    @Override
    public Memberaccount findBymaiid(int id) {
        return memberaccountMapper.selectBymaid(id);
    }
}
