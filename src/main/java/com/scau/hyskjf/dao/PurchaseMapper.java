package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Purchase;

public interface PurchaseMapper {
    int deleteByPrimaryKey(Integer purid);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer purid);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);
}