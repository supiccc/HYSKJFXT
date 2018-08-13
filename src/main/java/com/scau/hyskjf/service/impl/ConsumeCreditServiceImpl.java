package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.CreditsubmitMapper;
import com.scau.hyskjf.pojo.Creditsubmit;
import com.scau.hyskjf.service.ConsumeCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeCreditServiceImpl implements ConsumeCreditService {

    @Autowired
    private CreditsubmitMapper creditsubmitMapper;

    @Override
    public List<Creditsubmit> findAllSubmit(Object csstat) {
        return creditsubmitMapper.findAllSubmit(csstat);
    }

    @Override
    public boolean updateState(int id, boolean state) {
        Creditsubmit creditsubmit = new Creditsubmit();
        creditsubmit.setCsid(id);
        if(creditsubmitMapper.selectByPrimaryKey(id).getCsstat() == true){
            return false;
        }else {
            creditsubmit.setCsstat(state);
            creditsubmitMapper.updateByPrimaryKeySelective(creditsubmit);
            return true;
        }

    }
}
