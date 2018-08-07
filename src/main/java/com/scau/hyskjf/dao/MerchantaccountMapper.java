package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.pojo.MerchantaccountKey;

public interface MerchantaccountMapper {
    int deleteByPrimaryKey(MerchantaccountKey key);

    int insert(Merchantaccount record);

    int insertSelective(Merchantaccount record);

    Merchantaccount selectByPrimaryKey(MerchantaccountKey key);

    int updateByPrimaryKeySelective(Merchantaccount record);

    int updateByPrimaryKey(Merchantaccount record);
}