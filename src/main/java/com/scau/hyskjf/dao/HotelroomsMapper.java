package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Hotelrooms;

public interface HotelroomsMapper {
    int deleteByPrimaryKey(Integer pduid);

    int insert(Hotelrooms record);

    int insertSelective(Hotelrooms record);

    Hotelrooms selectByPrimaryKey(Integer pduid);

    int updateByPrimaryKeySelective(Hotelrooms record);

    int updateByPrimaryKey(Hotelrooms record);
}