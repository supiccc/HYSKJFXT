package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchant;

public interface MerchantMapper {
    int deleteByPrimaryKey(Integer merid);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer merid);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
}