package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Creditconsumedetail;

import java.util.List;

public interface CreditconsumedetailMapper {
    int insert(Creditconsumedetail record);

    int insertSelective(Creditconsumedetail record);

    List<Creditconsumedetail> findAllCreditsoncumeOrderByStateAndTime(Integer timeType,Integer stateType);

    List<Creditconsumedetail> findAllCreditsoncumeOrderByTime(Integer timeType);

    List<Creditconsumedetail> findAllCreditsoncumeOrderByState(Integer stateType);

    List<Creditconsumedetail> findAllCreditsoncume();

    Creditconsumedetail selectByPrimaryKey(Integer creconid);
}