package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantconfigure;

public interface MerchantconfigureMapper {
    int deleteByPrimaryKey(Integer merid);

    int insert(Merchantconfigure record);

    int insertSelective(Merchantconfigure record);

    Merchantconfigure selectByPrimaryKey(Integer merid);

    int updateByPrimaryKeySelective(Merchantconfigure record);

    int updateByPrimaryKey(Merchantconfigure record);
}