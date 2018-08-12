package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantaccount;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface MerchantaccountMapper {
    int deleteByPrimaryKey(Integer macid);

    int insert(Merchantaccount record);

    int insertSelective(Merchantaccount record);

    Merchantaccount selectByPrimaryKey(Integer macid);

    List<Merchantaccount> selectAll();

    List<Merchantaccount> selectByMerID(Integer merid);

    int updateByPrimaryKeySelective(Merchantaccount record);

    int updateByPrimaryKey(Merchantaccount record);

    Merchantaccount selectByMacAcc(String macAcc);

    int forbidBymerId(Merchantaccount merchantaccount);
}