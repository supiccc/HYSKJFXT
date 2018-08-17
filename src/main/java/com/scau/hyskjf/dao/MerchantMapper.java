package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantMapper {
    int deleteByPrimaryKey(Integer merid);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer merid);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);

    Integer getMerID();

    int updateAddCredit(@Param("merID")Integer merID,@Param("addCredit")Float addCredit);
}