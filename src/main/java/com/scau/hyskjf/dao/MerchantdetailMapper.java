package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.MerchantdetailWithBLOBs;

public interface MerchantdetailMapper {
    int insert(MerchantdetailWithBLOBs record);

    int insertSelective(MerchantdetailWithBLOBs record);
}