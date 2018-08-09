package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer memid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer memid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKeyWithBLOBs(Member record);

    int updateByPrimaryKey(Member record);
}