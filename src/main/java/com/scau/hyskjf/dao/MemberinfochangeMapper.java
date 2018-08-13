package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Memberinfochange;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> d76e751531137599dd03a5f1e0c6be40ff1e10cf
@Repository
public interface MemberinfochangeMapper {
    int deleteByPrimaryKey(Integer micid);

    int insert(Memberinfochange record);

    int insertSelective(Memberinfochange record);

    Memberinfochange selectByPrimaryKey(Integer micid);

    int updateByPrimaryKeySelective(Memberinfochange record);

    int updateByPrimaryKey(Memberinfochange record);

    List<Memberinfochange> findAllMemberinfochange();

    List<Memberinfochange> selectchangesByMemid(int memid);
}