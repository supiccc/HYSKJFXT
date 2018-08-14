package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Productinfo;

import org.springframework.stereotype.Repository;

import org.apache.ibatis.annotations.Param;
import java.util.List;

@Repository
public interface ProductinfoMapper {
    int deleteByPrimaryKey(Integer pduid);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);

    Productinfo selectByPrimaryKey(Integer pduid);

    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKey(Productinfo record);

    List<Productinfo> selectProductByMerID(Integer merId);

    List<Productinfo> queryLabelProduct(@Param("merID")Integer merID, @Param("labelID")Integer labelID);
}