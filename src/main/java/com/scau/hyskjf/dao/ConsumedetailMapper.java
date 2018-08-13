package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Consumedetail;

public interface ConsumedetailMapper {
    int insert(Consumedetail record);

    int insertSelective(Consumedetail record);
}