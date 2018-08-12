package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Membercard;
import org.springframework.stereotype.Repository;

@Repository
public interface MembercardMapper {
    int deleteByPrimaryKey(Integer mcpkid);

    int insert(Membercard record);

    int insertSelective(Membercard record);

    Membercard selectByPrimaryKey(Integer mcpkid);

    int updateByPrimaryKeySelective(Membercard record);

    int updateByPrimaryKey(Membercard record);
}