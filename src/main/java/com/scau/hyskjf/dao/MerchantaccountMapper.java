package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantaccount;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD


import java.util.List;


=======
import java.util.List;

>>>>>>> 98a3a73aa8b398d367cf0219d38e807340cb67f6
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