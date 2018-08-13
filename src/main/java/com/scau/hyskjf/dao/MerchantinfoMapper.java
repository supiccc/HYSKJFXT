package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantinfo;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;
import com.scau.hyskjf.pojo.MerchantinfomodifiedWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantinfoMapper {
    int deleteByPrimaryKey(Integer merid);

    int insert(MerchantinfoWithBLOBs record);

    int insertSelective(Merchantinfo record);

    MerchantinfoWithBLOBs selectByPrimaryKey(Integer merid);

    Merchantinfo findById(@Param("id") Integer merid);

    int updateByPrimaryKeySelective(MerchantinfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MerchantinfoWithBLOBs record);

    int updateByPrimaryKey(Merchantinfo record);

<<<<<<< HEAD
    MerchantinfoWithBLOBs findByMerName(@Param("mName") String merName);
=======
    int updateByModified(MerchantinfomodifiedWithBLOBs record);

    List<MerchantinfoWithBLOBs> findAllMerchantinfo();
>>>>>>> d76e751531137599dd03a5f1e0c6be40ff1e10cf
}