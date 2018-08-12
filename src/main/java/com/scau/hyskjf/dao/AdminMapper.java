package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminid);

    Admin selectByAcc(String adminacc);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}