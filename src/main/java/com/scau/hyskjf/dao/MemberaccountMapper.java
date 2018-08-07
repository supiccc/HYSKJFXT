package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Memberaccount;

public interface MemberaccountMapper {
    int deleteByPrimaryKey(Long memid);

    int insert(Memberaccount record);

    int insertSelective(Memberaccount record);

    Memberaccount selectByPrimaryKey(Long memid);

    int updateByPrimaryKeySelective(Memberaccount record);

    int updateByPrimaryKey(Memberaccount record);
}