package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantinfo;

public interface MerchantinfoMapper {
    int deleteByPrimaryKey(Integer merid);

    int insert(Merchantinfo record);

    int insertSelective(Merchantinfo record);

    Merchantinfo selectByPrimaryKey(Integer merid);

    int updateByPrimaryKeySelective(Merchantinfo record);

    int updateByPrimaryKeyWithBLOBs(Merchantinfo record);

    int updateByPrimaryKey(Merchantinfo record);
}