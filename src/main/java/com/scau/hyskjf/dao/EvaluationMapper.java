package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Evaluation;

public interface EvaluationMapper {
    int deleteByPrimaryKey(Integer evaid);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Integer evaid);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}