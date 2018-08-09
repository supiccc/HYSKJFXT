package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MemberaccountMapper;
import com.scau.hyskjf.pojo.Memberaccount;
import com.scau.hyskjf.service.MemberCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by supiccc on 2018-08-09 08:53
 */
@Service
public class MemberCenterServiceImpl implements MemberCenterService {
    @Autowired
    MemberaccountMapper memberaccountMapper;

    // 通过账号查找
    @Override
    public Memberaccount findBymaiid(int maid) {
        return memberaccountMapper.selectBymaid(maid);
    }
}
