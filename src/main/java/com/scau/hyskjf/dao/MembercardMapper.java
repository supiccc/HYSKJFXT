package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Membercard;
import com.scau.hyskjf.pojo.MembercardKey;

public interface MembercardMapper {
    int deleteByPrimaryKey(MembercardKey key);

    int insert(Membercard record);

    int insertSelective(Membercard record);

    Membercard selectByPrimaryKey(MembercardKey key);

    int updateByPrimaryKeySelective(Membercard record);

    int updateByPrimaryKey(Membercard record);
}