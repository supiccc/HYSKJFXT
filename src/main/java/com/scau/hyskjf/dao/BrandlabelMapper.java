package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Brandlabel;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface BrandlabelMapper {
    int deleteByPrimaryKey(Integer labelid);

    int insert(Brandlabel record);

    int insertSelective(Brandlabel record);

    Brandlabel selectByPrimaryKey(Integer labelid);

    int updateByPrimaryKeySelective(Brandlabel record);

    int updateByPrimaryKey(Brandlabel record);

    List<Brandlabel> queryAllLabel();

    List<Brandlabel> queryLabelByType(String labeltype);
}