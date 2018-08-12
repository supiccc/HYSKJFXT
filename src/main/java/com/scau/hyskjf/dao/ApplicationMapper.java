package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Application;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationMapper {
    int deleteByPrimaryKey(Integer acaid);

    int insert(Application record);

    int insertSelective(Application record);

    Application selectByPrimaryKey(Integer acaid);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);

    List<Application> findAllApplications(@Param("state")String state);

}