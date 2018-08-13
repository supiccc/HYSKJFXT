package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Brandlabel;
import com.scau.hyskjf.pojo.Merchantinfo;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;
import com.scau.hyskjf.pojo.MerchantinfomodifiedWithBLOBs;

import java.util.List;

public interface MerchantInfoService {
    MerchantinfoWithBLOBs queryByMerID(Integer merID);

    MerchantinfoWithBLOBs queryByMerName(String merName);

    int updateMerInfo(MerchantinfomodifiedWithBLOBs merchantinfomodifiedWithBLOBs);
}
