package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Consumedetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumedetailMapper {
    int insert(Consumedetail record);

    int insertSelective(Consumedetail record);

    List<Consumedetail> selectAllBymemID(Integer memid);

    Consumedetail selectByCumID(Integer cumID);
}