package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Requirement;
import com.scau.hyskjf.pojo.RequirementWithBLOBs;

public interface RequirementMapper {
    int deleteByPrimaryKey(Integer reqid);

    int insert(RequirementWithBLOBs record);

    int insertSelective(RequirementWithBLOBs record);

    RequirementWithBLOBs selectByPrimaryKey(Integer reqid);

    int updateByPrimaryKeySelective(RequirementWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RequirementWithBLOBs record);

    int updateByPrimaryKey(Requirement record);
}