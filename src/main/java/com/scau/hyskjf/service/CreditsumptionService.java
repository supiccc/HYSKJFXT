package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Creditconsume;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/8/14 9:09
 * @Version 1.0
 */
public interface CreditsumptionService {
    List<Creditconsume> findAllCreditsoncumeOrderByTime(int type);

    List<Creditconsume> findAllCreditsoncumeOrderByStateAndTime(int timeType, int stateType);

    Creditconsume findCreditconsume(int id);

    void updateState(int adminid, int creconId);

    List<Creditconsume> findAllCreditsoncumeOrderByState(Integer stateType);

    List<Creditconsume> findAllCreditsoncume();
}