package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Memberandcard;

public interface MemberandcardMapper {
    int insert(Memberandcard record);

    int insertSelective(Memberandcard record);
}