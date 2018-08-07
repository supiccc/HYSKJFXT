package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Requirement;

public interface RequirementMapper {
    int deleteByPrimaryKey(Integer reqid);

    int insert(Requirement record);

    int insertSelective(Requirement record);

    Requirement selectByPrimaryKey(Integer reqid);

    int updateByPrimaryKeySelective(Requirement record);

    int updateByPrimaryKey(Requirement record);
}