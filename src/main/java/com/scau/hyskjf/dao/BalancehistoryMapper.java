package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Balancehistory;

public interface BalancehistoryMapper {
    int deleteByPrimaryKey(Integer vhid);

    int insert(Balancehistory record);

    int insertSelective(Balancehistory record);

    Balancehistory selectByPrimaryKey(Integer vhid);

    int updateByPrimaryKeySelective(Balancehistory record);

    int updateByPrimaryKey(Balancehistory record);
}