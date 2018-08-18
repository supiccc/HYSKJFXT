package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.MManager;
import com.scau.hyskjf.pojo.Merchantaccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MerchantaccountMapper {
    int deleteByPrimaryKey(Integer macid);

    int insert(Merchantaccount record);

    int insertSelective(Merchantaccount record);

    Merchantaccount selectByPrimaryKey(Integer macid);

    List<Merchantaccount> selectAll();

    List<Merchantaccount> selectByMerID(Integer merID);

    int updateByPrimaryKeySelective(Merchantaccount record);

    int updateByPrimaryKey(Merchantaccount record);

    Merchantaccount selectByMacAcc(String macAcc);

    int forbidBymerId(Merchantaccount merchantaccount);

    List<MManager> queryManager(@Param("merID") Integer merID);

    int addPermission(@Param("macAcc") String macAcc,@Param("merId") Integer merId);

    Integer queryType(@Param("macAcc") String macAcc,@Param("merId") Integer merId);
}