package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Advertise;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertiseMapper {
    int deleteByPrimaryKey(Integer adverid);

    int insert(Advertise record);

    int insertSelective(Advertise record);

    Advertise selectByPrimaryKey(Integer adverid);

    int updateByPrimaryKeySelective(Advertise record);

    int updateByPrimaryKeyWithBLOBs(Advertise record);

    int updateByPrimaryKey(Advertise record);

    List<Advertise> findAllAdvertise();
}