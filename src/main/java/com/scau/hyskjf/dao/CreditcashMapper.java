package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Creditcash;

public interface CreditcashMapper {
    int deleteByPrimaryKey(Integer ccid);

    int insert(Creditcash record);

    int insertSelective(Creditcash record);

    Creditcash selectByPrimaryKey(Integer ccid);

    int updateByPrimaryKeySelective(Creditcash record);

    int updateByPrimaryKey(Creditcash record);
}