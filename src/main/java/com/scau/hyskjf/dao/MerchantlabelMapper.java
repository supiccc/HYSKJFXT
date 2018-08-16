package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantlabel;

public interface MerchantlabelMapper {
    int deleteByPrimaryKey(Integer labelid);

    int insert(Merchantlabel record);

    int insertSelective(Merchantlabel record);

    Merchantlabel selectByPrimaryKey(Integer labelid);

    int updateByPrimaryKeySelective(Merchantlabel record);

    int updateByPrimaryKey(Merchantlabel record);
}