package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.MerchantdetailWithBLOBs;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;
import com.scau.hyskjf.pojo.MerchantinfomodifiedWithBLOBs;

public interface MerchantInfoService {
    MerchantinfoWithBLOBs queryByMerID(Integer merID);

    MerchantinfoWithBLOBs queryByMerName(String merName);

    int updateMerInfo(MerchantinfomodifiedWithBLOBs merchantinfomodifiedWithBLOBs);

    MerchantdetailWithBLOBs findMerchantDetail(int merid);

    void insertCreditSubmit(Integer merid, Float credit, Float money);
}
