package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Creditexchange;

public interface CreditexchangeMapper {
    int deleteByPrimaryKey(Integer ceid);

    int insert(Creditexchange record);

    int insertSelective(Creditexchange record);

    Creditexchange selectByPrimaryKey(Integer ceid);

    int updateByPrimaryKeySelective(Creditexchange record);

    int updateByPrimaryKey(Creditexchange record);
}