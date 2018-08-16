package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Memberandcard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberandcardMapper {
    int insert(Memberandcard record);

    int insertSelective(Memberandcard record);

    Memberandcard selectByCarId(@Param("cardId") String cardId);
}