package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MerchantaccountMapper;
import com.scau.hyskjf.pojo.Merchantaccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantAccManageServiceImpl {
    @Autowired
    MerchantaccountMapper merchantaccountMapper;

    public void addMerchantAccount(Merchantaccount merchantaccount){

    }
}
