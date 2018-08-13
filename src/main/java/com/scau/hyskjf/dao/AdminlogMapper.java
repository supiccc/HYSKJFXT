package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Adminlog;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminlogMapper {
    int deleteByPrimaryKey(Integer adlogid);

    int insert(Adminlog record);

    int insertSelective(Adminlog record);

    Adminlog selectByPrimaryKey(Integer adlogid);

    int updateByPrimaryKeySelective(Adminlog record);

    int updateByPrimaryKeyWithBLOBs(Adminlog record);

    int updateByPrimaryKey(Adminlog record);
}