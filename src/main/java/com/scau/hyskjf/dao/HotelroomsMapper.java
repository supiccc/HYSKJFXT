package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Hotelrooms;
import com.scau.hyskjf.pojo.HotelroomsWithBLOBs;

public interface HotelroomsMapper {
    int deleteByPrimaryKey(Integer pduid);

    int insert(HotelroomsWithBLOBs record);

    int insertSelective(HotelroomsWithBLOBs record);

    HotelroomsWithBLOBs selectByPrimaryKey(Integer pduid);

    int updateByPrimaryKeySelective(HotelroomsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(HotelroomsWithBLOBs record);

    int updateByPrimaryKey(Hotelrooms record);
}