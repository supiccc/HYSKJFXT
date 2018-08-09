package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Creditsubmit;

public interface CreditsubmitMapper {
    int deleteByPrimaryKey(Integer csid);

    int insert(Creditsubmit record);

    int insertSelective(Creditsubmit record);

    Creditsubmit selectByPrimaryKey(Integer csid);

    int updateByPrimaryKeySelective(Creditsubmit record);

    int updateByPrimaryKey(Creditsubmit record);
}