package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.ApplicationMapper;
import com.scau.hyskjf.dao.MerchantMapper;
import com.scau.hyskjf.dao.MerchantinfoMapper;
import com.scau.hyskjf.pojo.Application;
import com.scau.hyskjf.pojo.Merchant;
import com.scau.hyskjf.pojo.Merchantinfo;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;
import com.scau.hyskjf.service.MerchantJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MerchantJoinServiceImpl implements MerchantJoinService {
    @Autowired
    MerchantMapper merchantMapper;

    @Autowired
    MerchantinfoMapper merchantinfoMapper;

    @Autowired
    ApplicationMapper applicationMapper;

    public Integer developJoin(MerchantinfoWithBLOBs merchantinfoWithBLOBs, Merchant merchant) {
        Integer createMerID = merchantMapper.getMerID();
        merchant.setMerid(createMerID);
        merchantMapper.insert(merchant);
        merchantinfoWithBLOBs.setMerid(createMerID);
        merchantinfoMapper.insert(merchantinfoWithBLOBs);
        Application application = new Application();
        application.setAcamerchant(merchant.getMersubid());//设置申请商家（上级）
        application.setAcaamerchant(createMerID);//设置入盟上级（本体）
        application.setAcareatime(new Date());//设置申请时间
        application.setAcastat("未处理");//设置审核状态
        applicationMapper.insert(application);
        return createMerID;
    }

    public Integer independentJoin(MerchantinfoWithBLOBs merchantinfoWithBLOBs, Merchant merchant) {
        Integer createMerID = merchantMapper.getMerID();
        merchant.setMerid(createMerID);
        merchantMapper.insert(merchant);
        Integer cMerID = createMerID;
        Merchant updateMerchant = new Merchant();
        updateMerchant.setMerid(cMerID);
        updateMerchant.setMersubid(cMerID);
        merchantMapper.updateByPrimaryKeySelective(updateMerchant);//更新父编号为merID
        merchantinfoWithBLOBs.setMerid(cMerID);
        merchantinfoMapper.insert(merchantinfoWithBLOBs);
        Application application = new Application();
        application.setAcamerchant(cMerID);//设置申请商家（上级）(顶级商家的上级为自己)
        application.setAcaamerchant(cMerID);//设置入盟商家（本体）
        application.setAcareatime(new Date());//设置申请时间
        application.setAcastat("未处理");//设置审核状态
        applicationMapper.insert(application);
        return createMerID;
    }
}
