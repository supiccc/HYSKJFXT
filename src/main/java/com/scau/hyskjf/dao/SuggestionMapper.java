package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Suggestion;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionMapper {
    int deleteByPrimaryKey(Integer sugid);

    int insert(Suggestion record);

    int insertSelective(Suggestion record);

    Suggestion selectByPrimaryKey(Integer sugid);

    int updateByPrimaryKeySelective(Suggestion record);

    int updateByPrimaryKeyWithBLOBs(Suggestion record);

    int updateByPrimaryKey(Suggestion record);
}