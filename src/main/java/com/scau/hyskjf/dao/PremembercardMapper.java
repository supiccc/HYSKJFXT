package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Premembercard;

public interface PremembercardMapper {
    int deleteByPrimaryKey(Long pmcid);

    int insert(Premembercard record);

    int insertSelective(Premembercard record);

    Premembercard selectByPrimaryKey(Long pmcid);

    int updateByPrimaryKeySelective(Premembercard record);

    int updateByPrimaryKey(Premembercard record);
}