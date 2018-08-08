package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantinfomodified;
import com.scau.hyskjf.pojo.MerchantinfomodifiedKey;
import com.scau.hyskjf.pojo.MerchantinfomodifiedWithBLOBs;

public interface MerchantinfomodifiedMapper {
    int deleteByPrimaryKey(MerchantinfomodifiedKey key);

    int insert(MerchantinfomodifiedWithBLOBs record);

    int insertSelective(MerchantinfomodifiedWithBLOBs record);

    MerchantinfomodifiedWithBLOBs selectByPrimaryKey(MerchantinfomodifiedKey key);

    int updateByPrimaryKeySelective(MerchantinfomodifiedWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MerchantinfomodifiedWithBLOBs record);

    int updateByPrimaryKey(Merchantinfomodified record);
}