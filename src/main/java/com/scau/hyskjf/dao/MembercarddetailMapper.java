package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Membercarddetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembercarddetailMapper {
    int insert(Membercarddetail record);

    int insertSelective(Membercarddetail record);

    List selectByMemID(Integer memid);
}