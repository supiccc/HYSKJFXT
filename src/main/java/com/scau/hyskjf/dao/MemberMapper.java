package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Long memid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Long memid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKeyWithBLOBs(Member record);

    int updateByPrimaryKey(Member record);
}