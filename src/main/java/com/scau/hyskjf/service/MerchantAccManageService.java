package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Merchantaccount;

import java.util.List;

public interface MerchantAccManageService {
    int addMerchantAccount(Merchantaccount merchantaccount);

    List<Merchantaccount> queryAllMerchantAccount();

    List<Merchantaccount> queryMerchantAccountByMerID(Integer merID);

    int updateMerchantAccount(Merchantaccount merchantaccount);

    Merchantaccount queryMerchantAccountByMacAcc(String macAcc);
}
