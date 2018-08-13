package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Operationlog;
import com.scau.hyskjf.pojo.OperationlogWithBLOBs;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationlogMapper {
    int deleteByPrimaryKey(Integer ologid);

    int insert(OperationlogWithBLOBs record);

    int insertSelective(OperationlogWithBLOBs record);

    OperationlogWithBLOBs selectByPrimaryKey(Integer ologid);

    int updateByPrimaryKeySelective(OperationlogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OperationlogWithBLOBs record);

    int updateByPrimaryKey(Operationlog record);
}