package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MerchantaccountMapper;
import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.service.MerchantAccManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantAccManageServiceImpl implements MerchantAccManageService {
    @Autowired
    MerchantaccountMapper merchantaccountMapper;

    public int addMerchantAccount(Merchantaccount merchantaccount){
        return merchantaccountMapper.insert(merchantaccount);
    }

    public List<Merchantaccount> queryAllMerchantAccount(){
        return merchantaccountMapper.selectAll();
    }

    public List<Merchantaccount> queryMerchantAccountByMerID(Integer merID){
        return merchantaccountMapper.selectByMerID(merID);
    }

    public int updateMerchantAccount(Merchantaccount merchantaccount){
        return merchantaccountMapper.updateByPrimaryKeySelective(merchantaccount);
    }

    public Merchantaccount queryMerchantAccountByMacAcc(String macAcc){
        return merchantaccountMapper.selectByMacAcc(macAcc);
    }
}
