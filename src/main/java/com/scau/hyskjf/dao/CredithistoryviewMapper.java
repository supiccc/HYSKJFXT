package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Credithistoryview;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CredithistoryviewMapper {
    int insert(Credithistoryview record);

    int insertSelective(Credithistoryview record);

    List<Credithistoryview> selectAll(int memID);
}