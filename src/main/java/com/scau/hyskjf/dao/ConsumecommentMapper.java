package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Consumecomment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumecommentMapper {
    int insert(Consumecomment record);

    int insertSelective(Consumecomment record);

    List<Consumecomment> selectByMerAndMem(Integer merID, Integer memId);

    List<Consumecomment> selectByMemID(Integer memId);
}