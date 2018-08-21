package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.CreditsubmitdetailWithBLOBs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditsubmitdetailMapper {
    int insert(CreditsubmitdetailWithBLOBs record);

    int insertSelective(CreditsubmitdetailWithBLOBs record);

    List<CreditsubmitdetailWithBLOBs> findAllSubmit(Object csstat);

    List<CreditsubmitdetailWithBLOBs> findAllSubmitWithState(boolean csstat);

    List<CreditsubmitdetailWithBLOBs> findAllUnhandleSubmit();
}