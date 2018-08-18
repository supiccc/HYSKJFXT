package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Creditconsume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditconsumeMapper {
    int deleteByPrimaryKey(Integer creconid);

    int insert(Creditconsume record);

    int insertSelective(Creditconsume record);

    Creditconsume selectByPrimaryKey(Integer creconid);

    int updateByPrimaryKeySelective(Creditconsume record);

    int updateByPrimaryKey(Creditconsume record);

    List<Creditconsume> findAllCreditsoncumeOrderByStateAndTime(@Param(value = "timeType") int timeType,
                                                                @Param(value = "stateType") int stateType);

    List<Creditconsume> findAllCreditsoncumeOrderByTime(@Param(value = "timeType")int timeType);

    List<Creditconsume> findAllCreditsoncumeOrderByState(@Param(value = "stateType") int stateType);

    List<Creditconsume> findAllCreditsoncume();
}