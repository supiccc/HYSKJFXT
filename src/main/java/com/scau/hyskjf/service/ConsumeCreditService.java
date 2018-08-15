package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Creditsubmit;

import java.util.List;

public interface ConsumeCreditService {
    List<Creditsubmit> findAllSubmit(Object csstat);

    boolean updateState(int id, boolean state);
}
