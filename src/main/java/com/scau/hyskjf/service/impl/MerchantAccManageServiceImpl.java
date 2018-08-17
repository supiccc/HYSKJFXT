package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MembermanagerMapper;
import com.scau.hyskjf.dao.MerchantMapper;
import com.scau.hyskjf.dao.MerchantaccountMapper;
import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.MerchantAccManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantAccManageServiceImpl implements MerchantAccManageService {
    @Autowired
    MerchantaccountMapper merchantaccountMapper;

    @Autowired
    MembermanagerMapper membermanagerMapper;

    @Autowired
    MerchantMapper merchantMapper;

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

    public int setMemberManager(List<Membermanager> mmList){
        return membermanagerMapper.insertmmList(mmList);
    }

    public List<MemberMShow> queryMemberByMerID(Integer merID){
        List<MemberMShow> list = merchantMapper.queryMember(merID);
        return  list;
    }

    public List<MManager> queryMemberManagerByMerID(Integer merID){
        List<MManager> list = merchantaccountMapper.queryManager(merID);
        return list;
    }
}
