package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.CreditsubmitdetailWithBLOBs;

import java.util.List;

public interface ConsumeCreditService {
    List<CreditsubmitdetailWithBLOBs> findAllSubmit(Object csstat);

    boolean updateState(int id, boolean state);

    List<CreditsubmitdetailWithBLOBs> findAllSubmitWithState(boolean b);

    List<CreditsubmitdetailWithBLOBs> findAllUnhandleSubmit(boolean b);
}
