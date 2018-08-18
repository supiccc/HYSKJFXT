package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.CreditconsumeMapper;
import com.scau.hyskjf.dao.CreditconsumedetailMapper;
import com.scau.hyskjf.pojo.Creditconsume;
import com.scau.hyskjf.pojo.Creditconsumedetail;
import com.scau.hyskjf.service.CreditsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/8/14 9:09
 * @Version 1.0
 */
@Service
public class CreditsumptionServiceImpl implements CreditsumptionService {
    @Autowired
    private CreditconsumeMapper creditconsumeMapper;

    @Autowired
    private CreditconsumedetailMapper creditconsumedetailMapper;

    @Override
    public List<Creditconsume> findAllCreditsoncumeOrderByTime(int type) {
        return creditconsumeMapper.findAllCreditsoncumeOrderByTime(type);
    }

    @Override
    public List<Creditconsume> findAllCreditsoncumeOrderByStateAndTime(int timeType, int stateType) {
        return creditconsumeMapper.findAllCreditsoncumeOrderByStateAndTime(timeType,stateType);
    }

    @Override
    public Creditconsume findCreditconsume(int id) {
        return creditconsumeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateState(int adminid, int creconId) {
        Creditconsume creditconsume = creditconsumeMapper.selectByPrimaryKey(creconId);
        creditconsume.setAdminid(adminid);
        creditconsume.setCreconid(creconId);
        creditconsume.setTransferstate(true);
        creditconsume.setHandletime(new Date());
        System.out.println(creditconsume.getAdminid());
        System.out.println(creditconsume.getCreconid());
        System.out.println(creditconsume.getHandletime());
        creditconsumeMapper.updateByPrimaryKey(creditconsume);
    }

    @Override
    public List<Creditconsume> findAllCreditsoncumeOrderByState(Integer stateType) {
        return creditconsumeMapper.findAllCreditsoncumeOrderByState(stateType);
    }

    @Override
    public List<Creditconsume> findAllCreditsoncume() {
        return creditconsumeMapper.findAllCreditsoncume();
    }

    @Override
    public List<Creditconsumedetail> findAllCreditsoncumeDetailOrderByTime(Integer timeType) {
        return creditconsumedetailMapper.findAllCreditsoncumeOrderByTime(timeType);
    }

    @Override
    public List<Creditconsumedetail> findAllCreditsoncumeDetailOrderByStateAndTime(Integer timeType, Integer stateType) {
        return creditconsumedetailMapper.findAllCreditsoncumeOrderByStateAndTime(timeType,stateType);
    }

    @Override
    public List<Creditconsumedetail> findAllCreditsoncumeDetailOrderByState(Integer stateType) {
        return creditconsumedetailMapper.findAllCreditsoncumeOrderByState(stateType);
    }

    @Override
    public List<Creditconsumedetail> findAllCreditsoncumeDetail() {
        return creditconsumedetailMapper.findAllCreditsoncume();
    }

    @Override
    public Creditconsumedetail findCreditconsumeDetail(int id) {
        return creditconsumedetailMapper.selectByPrimaryKey(id);
    }
}
