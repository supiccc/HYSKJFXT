package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantinfomodified;
import com.scau.hyskjf.pojo.MerchantinfomodifiedWithBLOBs;

public interface MerchantinfomodifiedMapper {
    int deleteByPrimaryKey(Integer attribute249);

    int insert(MerchantinfomodifiedWithBLOBs record);

    int insertSelective(MerchantinfomodifiedWithBLOBs record);

    MerchantinfomodifiedWithBLOBs selectByPrimaryKey(Integer attribute249);

    int updateByPrimaryKeySelective(MerchantinfomodifiedWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MerchantinfomodifiedWithBLOBs record);

    int updateByPrimaryKey(Merchantinfomodified record);
}