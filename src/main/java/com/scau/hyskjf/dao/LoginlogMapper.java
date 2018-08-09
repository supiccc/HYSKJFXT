package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Loginlog;

public interface LoginlogMapper {
    int deleteByPrimaryKey(Integer llogid);

    int insert(Loginlog record);

    int insertSelective(Loginlog record);

    Loginlog selectByPrimaryKey(Integer llogid);

    int updateByPrimaryKeySelective(Loginlog record);

    int updateByPrimaryKey(Loginlog record);
}