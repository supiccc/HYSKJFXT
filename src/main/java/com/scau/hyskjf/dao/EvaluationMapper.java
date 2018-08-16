package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Evaluation;
import com.scau.hyskjf.pojo.EvaluationWithBLOBs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationMapper {
    int deleteByPrimaryKey(Integer evaid);

    int insert(EvaluationWithBLOBs record);

    int insertSelective(EvaluationWithBLOBs record);

    EvaluationWithBLOBs selectByPrimaryKey(Integer evaid);

    int updateByPrimaryKeySelective(EvaluationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EvaluationWithBLOBs record);

    int updateByPrimaryKey(Evaluation record);

    List<EvaluationWithBLOBs> selectByMerid(Integer merid);
}