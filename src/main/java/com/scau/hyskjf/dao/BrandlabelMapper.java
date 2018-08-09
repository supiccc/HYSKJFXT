package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Brandlabel;

public interface BrandlabelMapper {
    int deleteByPrimaryKey(Integer labelid);

    int insert(Brandlabel record);

    int insertSelective(Brandlabel record);

    Brandlabel selectByPrimaryKey(Integer labelid);

    int updateByPrimaryKeySelective(Brandlabel record);

    int updateByPrimaryKey(Brandlabel record);
}