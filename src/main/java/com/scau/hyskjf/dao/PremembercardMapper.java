package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Premembercard;
import org.springframework.stereotype.Repository;

@Repository
public interface PremembercardMapper {
    int deleteByPrimaryKey(Integer pmcid);

    int insert(Premembercard record);

    int insertSelective(Premembercard record);

    Premembercard selectByPrimaryKey(Integer pmcid);

    int updateByPrimaryKeySelective(Premembercard record);

    int updateByPrimaryKey(Premembercard record);
}