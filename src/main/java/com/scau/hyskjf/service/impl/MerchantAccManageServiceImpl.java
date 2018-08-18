package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.MembermanagerMapper;
import com.scau.hyskjf.dao.MerchantMapper;
import com.scau.hyskjf.dao.MerchantaccountMapper;
import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.MerchantAccManageService;
import org.apache.shiro.crypto.hash.Md5Hash;
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
        Md5Hash md5Hash =new Md5Hash(merchantaccount.getMacpasswd(),merchantaccount.getMacacc(),3);//MD5加密密码,登陆名作掩码，加密3次
        String MD5pwd = md5Hash.toString();
        merchantaccount.setMacpasswd(MD5pwd);
        merchantaccount.setMacenable(true);
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

    public int addPermissionByMacAcc(String macacc,Integer merid){
        Integer type  = merchantaccountMapper.queryType(macacc,merid);
        if(type>=10){
            return -1;
        }
        return merchantaccountMapper.addPermission(macacc,merid);
    }
}
