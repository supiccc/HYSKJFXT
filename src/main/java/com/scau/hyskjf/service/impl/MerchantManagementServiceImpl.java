package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MerchantMapper;
import com.scau.hyskjf.dao.MerchantaccountMapper;
import com.scau.hyskjf.dao.MerchantdetailMapper;
import com.scau.hyskjf.dao.MerchantinfoMapper;
import com.scau.hyskjf.pojo.*;
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
    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private MerchantdetailMapper merchantdetailMapper;


    @Override
    public Merchantdetail setRecommend(int id) {
        Merchant merchant = new Merchant();
        merchant.setMerid(id);
        merchant.setMerrecommend(true);
        merchantMapper.updateByPrimaryKeySelective(merchant);
        Merchantdetail merchantdetail = merchantdetailMapper.selectByPrimaryKey(id);

        return merchantdetail;
    }

    @Override
    public List<MerchantdetailWithBLOBs> findAllMerchant() {
        return merchantdetailMapper.findAllMerchantinfo();
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

    @Override
    public Merchantdetail setUnrecommend(int id) {
        Merchant merchant = new Merchant();
        merchant.setMerid(id);
        merchant.setMerrecommend(false);
        merchantMapper.updateByPrimaryKeySelective(merchant);
        Merchantdetail merchantdetail = merchantdetailMapper.selectByPrimaryKey(id);
        return merchantdetail;
    }

    @Override
    public Merchantdetail setIndex(int id) {
        Merchant merchant = merchantMapper.selectByPrimaryKey(id);
        if(merchant.getMerrecommend() != true){
            return null;
        }else {
            merchant.setIsindex(true);
            merchantMapper.updateByPrimaryKey(merchant);
            Merchantdetail merchantdetail = merchantdetailMapper.selectByPrimaryKey(id);
            return merchantdetail;
        }
    }

    @Override
    public Merchantdetail setNotIndex(int id) {
        Merchant merchant = merchantMapper.selectByPrimaryKey(id);
        merchant.setIsindex(false);
        merchantMapper.updateByPrimaryKey(merchant);
        return merchantdetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MerchantdetailWithBLOBs> findMerchantDetailByWord(String merName, String province,
                                                                  String city, String area,String type,
                                                                  Integer merrecommend,Integer isindex) {
        return merchantdetailMapper.findMerchantDetailByWord(merName,province,city,area,type,merrecommend,isindex);
    }
}
