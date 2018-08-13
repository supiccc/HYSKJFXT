package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Membercardreceive;
import org.springframework.stereotype.Repository;

@Repository
public interface MembercardreceiveMapper {
    int deleteByPrimaryKey(Integer mcrid);

    int insert(Membercardreceive record);

    int insertSelective(Membercardreceive record);

    Membercardreceive selectByPrimaryKey(Integer mcrid);

    int updateByPrimaryKeySelective(Membercardreceive record);

    int updateByPrimaryKey(Membercardreceive record);
}