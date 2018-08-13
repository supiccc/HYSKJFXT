package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Creditexchange;
import com.scau.hyskjf.pojo.CreditexchangeWithBLOBs;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditexchangeMapper {
    int deleteByPrimaryKey(Integer ceid);

    int insert(CreditexchangeWithBLOBs record);

    int insertSelective(CreditexchangeWithBLOBs record);

    CreditexchangeWithBLOBs selectByPrimaryKey(Integer ceid);

    int updateByPrimaryKeySelective(CreditexchangeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CreditexchangeWithBLOBs record);

    int updateByPrimaryKey(Creditexchange record);
}