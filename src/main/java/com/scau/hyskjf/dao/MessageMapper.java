package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer mesid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer mesid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
}