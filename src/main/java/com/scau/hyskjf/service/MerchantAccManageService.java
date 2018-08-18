package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantAccManageService {
    int addMerchantAccount(Merchantaccount merchantaccount);

    List<Merchantaccount> queryAllMerchantAccount();

    List<Merchantaccount> queryMerchantAccountByMerID(Integer merID);

    int updateMerchantAccount(Merchantaccount merchantaccount);

    Merchantaccount queryMerchantAccountByMacAcc(String macAcc);

    int setMemberManager(List<Membermanager> mmList);

    List<MemberMShow> queryMemberByMerID(Integer merID);

    List<MManager> queryMemberManagerByMerID(Integer merID);

    int addPermissionByMacAcc(String macacc,Integer merid);
}
