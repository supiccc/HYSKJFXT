package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Membermanager;

public interface MembermanagerMapper {
    int deleteByPrimaryKey(Integer mmaid);

    int insert(Membermanager record);

    int insertSelective(Membermanager record);

    Membermanager selectByPrimaryKey(Integer mmaid);

    int updateByPrimaryKeySelective(Membermanager record);

    int updateByPrimaryKey(Membermanager record);
}