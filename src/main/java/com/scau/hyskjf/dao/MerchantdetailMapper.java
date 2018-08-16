package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantdetail;
import com.scau.hyskjf.pojo.MerchantdetailWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantdetailMapper {
    int insert(MerchantdetailWithBLOBs record);

    int insertSelective(MerchantdetailWithBLOBs record);

    Merchantdetail selectByPrimaryKey(int merid);

    List<MerchantdetailWithBLOBs> selectAll();

    MerchantdetailWithBLOBs selectByMerID(Integer merid);

    List<MerchantdetailWithBLOBs> findMerchantDetailByWord(@Param("mername") String mername,
                                                           @Param("merprovince") String merprovince,
                                                           @Param("mercity") String mercity,
                                                           @Param("merarea") String merarea,
                                                           @Param("mertype") String mertype,
                                                           @Param("merrecommend") Integer merrecommend,
                                                           @Param("isindex") Integer isindex);

    List<MerchantdetailWithBLOBs> findAllMerchantinfo();
}