package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;

import java.util.List;

public interface MerchantManagementService {
    List<MerchantinfoWithBLOBs> findAllMerchant();

    MerchantinfoWithBLOBs findMerchantById(int id);

    List<Merchantaccount>  findMerchantAccountsById(int id);

    Merchantaccount findMerchantAccountById(int id);

    void forbidMerchantAccounts(int merid);

    void enableMerchantAccounts(int merid);
}
