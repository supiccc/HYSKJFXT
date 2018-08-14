package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Memberinfochange;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
import java.util.List;
=======

import java.util.List;

>>>>>>> 9b4ff9ea42253397b4b07419e093159430660d1f
@Repository
public interface MemberinfochangeMapper {
    int deleteByPrimaryKey(Integer micid);

    int insert(Memberinfochange record);

    int insertSelective(Memberinfochange record);

    Memberinfochange selectByPrimaryKey(Integer micid);

    int updateByPrimaryKeySelective(Memberinfochange record);

    int updateByPrimaryKey(Memberinfochange record);

    List<Memberinfochange> findAllMemberinfochange();

    List<Memberinfochange> selectchangesByMemid(int memid);
}