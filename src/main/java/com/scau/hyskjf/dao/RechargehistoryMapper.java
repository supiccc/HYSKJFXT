package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Rechargehistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargehistoryMapper {
    int deleteByPrimaryKey(Integer rhid);

    int insert(Rechargehistory record);

    int insertSelective(Rechargehistory record);

    Rechargehistory selectByPrimaryKey(Integer rhid);

    int updateByPrimaryKeySelective(Rechargehistory record);

    int updateByPrimaryKey(Rechargehistory record);

    List<Rechargehistory> findRechargeHistoryByCardId(String cardId);

    List<Rechargehistory> findRechargeHistoryByMerId(Integer merid);
}