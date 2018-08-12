package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MerchantaccountMapper;
import com.scau.hyskjf.dao.MerchantinfoMapper;
import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;
import com.scau.hyskjf.service.MerchantManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantManagementServiceImpl implements MerchantManagementService {
    @Autowired
    private MerchantinfoMapper merchantinfoMapper;
    @Autowired
    private MerchantaccountMapper merchantaccountMapper;

    @Override
    public List<MerchantinfoWithBLOBs> findAllMerchant() {
        return merchantinfoMapper.findAllMerchantinfo();
    }

    @Override
    public MerchantinfoWithBLOBs findMerchantById(int id) {
        MerchantinfoWithBLOBs merchantinfoWithBLOBs = merchantinfoMapper.selectByPrimaryKey(id);
        return merchantinfoWithBLOBs;
    }

    @Override
    public List<Merchantaccount> findMerchantAccountsById(int id) {
        List<Merchantaccount> merchantaccounts = merchantaccountMapper.selectByMerID(id);
        return merchantaccounts;
    }

    @Override
    public Merchantaccount findMerchantAccountById(int id) {
        Merchantaccount merchantaccount = merchantaccountMapper.selectByPrimaryKey(id);
        return merchantaccount;
    }

    @Override
    public void forbidMerchantAccounts(int merid) {
        Merchantaccount merchantaccount = new Merchantaccount();
        merchantaccount.setMerid(merid);
        merchantaccount.setMacenable(false);
        merchantaccountMapper.forbidBymerId(merchantaccount);
    }

    @Override
    public void enableMerchantAccounts(int merid) {
        Merchantaccount merchantaccount = new Merchantaccount();
        merchantaccount.setMerid(merid);
        merchantaccount.setMacenable(true);
        merchantaccountMapper.forbidBymerId(merchantaccount);
    }
}
