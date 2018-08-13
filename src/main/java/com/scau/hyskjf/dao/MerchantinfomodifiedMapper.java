package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantinfomodified;
import com.scau.hyskjf.pojo.MerchantinfomodifiedWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantinfomodifiedMapper {
    int deleteByPrimaryKey(Integer modifiedid);

    int insert(MerchantinfomodifiedWithBLOBs record);

    int insertSelective(MerchantinfomodifiedWithBLOBs record);

    MerchantinfomodifiedWithBLOBs selectByPrimaryKey(Integer modifiedid);

    int updateByPrimaryKeySelective(MerchantinfomodifiedWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MerchantinfomodifiedWithBLOBs record);

    int updateByPrimaryKey(Merchantinfomodified record);

    List<MerchantinfomodifiedWithBLOBs> findAllMerchantModified(@Param("state") String state);
}