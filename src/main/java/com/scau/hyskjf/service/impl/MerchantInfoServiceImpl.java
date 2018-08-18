package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.CreditsubmitMapper;
import com.scau.hyskjf.dao.MerchantdetailMapper;
import com.scau.hyskjf.dao.MerchantinfoMapper;
import com.scau.hyskjf.dao.MerchantinfomodifiedMapper;
import com.scau.hyskjf.pojo.Creditsubmit;
import com.scau.hyskjf.pojo.MerchantdetailWithBLOBs;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;
import com.scau.hyskjf.pojo.MerchantinfomodifiedWithBLOBs;
import com.scau.hyskjf.service.MerchantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantInfoServiceImpl implements MerchantInfoService {
    @Autowired
    MerchantinfoMapper merchantinfoMapper;

    @Autowired
    MerchantdetailMapper merchantdetailMapper;

    @Autowired
    MerchantinfomodifiedMapper merchantinfomodifiedMapper;
    @Autowired
    CreditsubmitMapper creditsubmitMapper;

    public MerchantinfoWithBLOBs queryByMerID(Integer merID){
        return merchantinfoMapper.selectByPrimaryKey(merID);
    }

    public MerchantinfoWithBLOBs queryByMerName(String merName){
        return merchantinfoMapper.findByMerName(merName);
    }

    public int updateMerInfo(MerchantinfomodifiedWithBLOBs merchantinfomodifiedWithBLOBs){
        return merchantinfomodifiedMapper.insert(merchantinfomodifiedWithBLOBs);
    }

    @Override
    public MerchantdetailWithBLOBs findMerchantDetail(int merid) {
        return merchantdetailMapper.selectByMerID(merid);
    }

    @Override
    public void insertCreditSubmit(Integer merid, Float credit, Float money) {
        Creditsubmit creditsubmit = new Creditsubmit();
        creditsubmit.setMerid(merid);
        creditsubmit.setCsmoney(money);
        creditsubmit.setCscredit(credit);
        creditsubmitMapper.insertSelective(creditsubmit);
    }
}
