package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.CreditsubmitMapper;
import com.scau.hyskjf.dao.CreditsubmitdetailMapper;
import com.scau.hyskjf.dao.MerchantMapper;
import com.scau.hyskjf.pojo.Creditsubmit;
import com.scau.hyskjf.pojo.CreditsubmitdetailWithBLOBs;
import com.scau.hyskjf.pojo.Merchant;
import com.scau.hyskjf.service.ConsumeCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeCreditServiceImpl implements ConsumeCreditService {

    @Autowired
    private CreditsubmitMapper creditsubmitMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private CreditsubmitdetailMapper creditsubmitdetailMapper;

    @Override
    public List<CreditsubmitdetailWithBLOBs> findAllSubmit(Object csstat) {
       // return creditsubmitMapper.findAllSubmit(csstat);
        return creditsubmitdetailMapper.findAllSubmit(csstat);
    }

    @Override
    public boolean updateState(int id, boolean state) {
        Creditsubmit creditsubmit = new Creditsubmit();
        creditsubmit.setCsid(id);
        //如果状态为true，则不能被修改
//        creditsubmit = creditsubmitMapper.selectByPrimaryKey(id);
        if(null != creditsubmitMapper.selectByPrimaryKey(id).getCsstat()){
            return false;
        }else if(state){  //若果状态不为true且修改状态为true

            //通过审核
            creditsubmit.setCsstat(state);
            creditsubmitMapper.updateByPrimaryKeySelective(creditsubmit);
            creditsubmit = creditsubmitMapper.selectByPrimaryKey(id);
            //减去商家表的对应积分
            float credits = creditsubmit.getCscredit();
            Merchant merchant = merchantMapper.selectByPrimaryKey(creditsubmit.getMerid());
            float merchantCredit = merchant.getOwecredit();
            merchant.setOwecredit(merchantCredit - credits);
            merchantMapper.updateByPrimaryKey(merchant);
            return true;
        }else {
            creditsubmit.setCsstat(state);
            creditsubmitMapper.updateByPrimaryKeySelective(creditsubmit);
            return true;
        }

    }

    @Override
    public List<CreditsubmitdetailWithBLOBs> findAllSubmitWithState(boolean b) {
        return creditsubmitdetailMapper.findAllSubmitWithState(b);
    }

    @Override
    public List<CreditsubmitdetailWithBLOBs> findAllUnhandleSubmit(boolean b) {
        return creditsubmitdetailMapper.findAllUnhandleSubmit();
    }
}
