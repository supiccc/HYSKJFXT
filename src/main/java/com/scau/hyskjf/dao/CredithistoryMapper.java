package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Credithistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CredithistoryMapper {
    int deleteByPrimaryKey(Integer chid);

    int insert(Credithistory record);

    int insertSelective(Credithistory record);

    Credithistory selectByPrimaryKey(Integer chid);

    int updateByPrimaryKeySelective(Credithistory record);

    int updateByPrimaryKeyWithBLOBs(Credithistory record);

    int updateByPrimaryKey(Credithistory record);
}