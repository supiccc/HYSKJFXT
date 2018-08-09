package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Evaluation;
import com.scau.hyskjf.pojo.EvaluationWithBLOBs;

public interface EvaluationMapper {
    int deleteByPrimaryKey(Integer evaid);

    int insert(EvaluationWithBLOBs record);

    int insertSelective(EvaluationWithBLOBs record);

    EvaluationWithBLOBs selectByPrimaryKey(Integer evaid);

    int updateByPrimaryKeySelective(EvaluationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EvaluationWithBLOBs record);

    int updateByPrimaryKey(Evaluation record);
}