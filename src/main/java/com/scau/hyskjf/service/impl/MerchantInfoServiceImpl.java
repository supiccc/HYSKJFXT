package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.*;
import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.MerchantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantInfoServiceImpl implements MerchantInfoService {
    @Autowired
    MerchantinfoMapper merchantinfoMapper;

    @Autowired
    MerchantinfomodifiedMapper merchantinfomodifiedMapper;

    public MerchantinfoWithBLOBs queryByMerID(Integer merID){
        return merchantinfoMapper.selectByPrimaryKey(merID);
    }

    public MerchantinfoWithBLOBs queryByMerName(String merName){
        return merchantinfoMapper.findByMerName(merName);
    }

    public int updateMerInfo(MerchantinfomodifiedWithBLOBs merchantinfomodifiedWithBLOBs){
        return merchantinfomodifiedMapper.insert(merchantinfomodifiedWithBLOBs);
    }
}
