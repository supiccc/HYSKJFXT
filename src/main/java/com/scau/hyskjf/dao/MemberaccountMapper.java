package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Memberaccount;

public interface MemberaccountMapper {
    int deleteByPrimaryKey(Integer memid);

    int insert(Memberaccount record);

    int insertSelective(Memberaccount record);

    Memberaccount selectByPrimaryKey(Integer memid);

    int updateByPrimaryKeySelective(Memberaccount record);

    int updateByPrimaryKey(Memberaccount record);

    Memberaccount selectBymaid(int id);
}