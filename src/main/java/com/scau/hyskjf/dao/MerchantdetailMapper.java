package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantdetail;
import com.scau.hyskjf.pojo.MerchantdetailWithBLOBs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantdetailMapper {
    int insert(MerchantdetailWithBLOBs record);

    int insertSelective(MerchantdetailWithBLOBs record);

    Merchantdetail selectByPrimaryKey(int merid);

    List<MerchantdetailWithBLOBs> selectAll();

    MerchantdetailWithBLOBs selectByMerID(Integer merid);
}