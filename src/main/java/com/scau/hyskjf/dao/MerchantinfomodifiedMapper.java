package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantinfomodified;
import com.scau.hyskjf.pojo.MerchantinfomodifiedKey;

public interface MerchantinfomodifiedMapper {
    int deleteByPrimaryKey(MerchantinfomodifiedKey key);

    int insert(Merchantinfomodified record);

    int insertSelective(Merchantinfomodified record);

    Merchantinfomodified selectByPrimaryKey(MerchantinfomodifiedKey key);

    int updateByPrimaryKeySelective(Merchantinfomodified record);

    int updateByPrimaryKeyWithBLOBs(Merchantinfomodified record);

    int updateByPrimaryKey(Merchantinfomodified record);
}