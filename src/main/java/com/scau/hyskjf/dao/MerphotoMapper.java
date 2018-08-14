package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merphoto;

public interface MerphotoMapper {
    int deleteByPrimaryKey(Integer photoid);

    int insert(Merphoto record);

    int insertSelective(Merphoto record);

    Merphoto selectByPrimaryKey(Integer photoid);

    int updateByPrimaryKeySelective(Merphoto record);

    int updateByPrimaryKey(Merphoto record);
}