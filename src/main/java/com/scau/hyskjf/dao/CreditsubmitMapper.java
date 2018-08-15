package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Creditsubmit;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreditsubmitMapper {
    int deleteByPrimaryKey(Integer csid);

    int insert(Creditsubmit record);

    int insertSelective(Creditsubmit record);

    Creditsubmit selectByPrimaryKey(Integer csid);

    int updateByPrimaryKeySelective(Creditsubmit record);

    int updateByPrimaryKey(Creditsubmit record);

    List<Creditsubmit> findAllSubmit(Object csstat);
}