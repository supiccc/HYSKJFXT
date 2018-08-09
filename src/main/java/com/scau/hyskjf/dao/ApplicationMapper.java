package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Application;

public interface ApplicationMapper {
    int deleteByPrimaryKey(Integer acaid);

    int insert(Application record);

    int insertSelective(Application record);

    Application selectByPrimaryKey(Integer acaid);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);
}