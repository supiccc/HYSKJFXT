package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Creditconsume;

public interface CreditconsumeMapper {
    int deleteByPrimaryKey(Integer creconid);

    int insert(Creditconsume record);

    int insertSelective(Creditconsume record);

    Creditconsume selectByPrimaryKey(Integer creconid);

    int updateByPrimaryKeySelective(Creditconsume record);

    int updateByPrimaryKey(Creditconsume record);
}