package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Consume;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumeMapper {
    int deleteByPrimaryKey(Integer cumid);

    int insert(Consume record);

    int insertSelective(Consume record);

    Consume selectByPrimaryKey(Integer cumid);

    int updateByPrimaryKeySelective(Consume record);

    int updateByPrimaryKey(Consume record);

//    List<Consume> selectByMerAndMem(Integer merID, Integer memId);
}