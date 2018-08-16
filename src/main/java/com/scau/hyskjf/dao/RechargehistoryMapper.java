package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Rechargehistory;

public interface RechargehistoryMapper {
    int deleteByPrimaryKey(Integer rhid);

    int insert(Rechargehistory record);

    int insertSelective(Rechargehistory record);

    Rechargehistory selectByPrimaryKey(Integer rhid);

    int updateByPrimaryKeySelective(Rechargehistory record);

    int updateByPrimaryKey(Rechargehistory record);
}