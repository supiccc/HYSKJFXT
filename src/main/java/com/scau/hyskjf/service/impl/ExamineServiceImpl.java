package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.*;
import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.ExamineService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ExamineServiceImpl implements ExamineService {

    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private MerchantinfomodifiedMapper merchantinfomodifiedMapper;

    @Autowired
    private MerchantinfoMapper merchantinfoMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private MerchantaccountMapper merchantaccountMapper;

    @Override
    public List<Application> findAllApplications(String state) {
        //查询所有状态为未处理的申请，并返回
        List<Application> applicationList = applicationMapper.findAllApplications(state);
        return applicationList;
    }

    @Override
    public Merchantinfo findApplicationById(int id) {
        //查询商家编号为id的商家资料，返回
        return merchantinfoMapper.findById(id);
    }




    @Override
    @Transactional
    public Merchantaccount applicationAgree(int id,int operator) {
        Application application = new Application();
        application.setAcaid(id);
        application.setAcastat("已通过");
        application.setAcareallo(operator);
        application.setAcareatime(new Date());
        applicationMapper.updateByPrimaryKeySelective(application);
        Merchant merchant = new Merchant();
        merchant.setMerid(id);
        merchant.setMerappstat(true);
        merchantMapper.updateByPrimaryKeySelective(merchant);
        application = applicationMapper.selectByPrimaryKey(id);
        Merchantaccount merchantaccount = new Merchantaccount();
        //如果申请商家和入盟商家不是同一个，则为同系统的
        if(application.getAcaamerchant()!= null &&
           application.getAcaamerchant() != application.getAcamerchant() &&
           application.getAcamerchant()!= null){
            //分配账号
            merchantaccount.setMerid(application.getAcaamerchant());
            merchantaccount.setMacacc(""+application.getAcaamerchant());
            String password = new Md5Hash("111111", merchantaccount.getMacid(), 3).toString();
            merchantaccount.setMacpasswd(password);
            merchantaccount.setMacacctype(1);
            merchantaccount.setMacenable(true);
            Merchantaccount merchantaccount1 = merchantaccountMapper.selectByPrimaryKey(application.getAcamerchant());
            merchantaccount.setMaccumacc(merchantaccount1.getMaccumacc());
            merchantaccountMapper.insertSelective(merchantaccount);
        }else { //如果申请商家和入盟商家是同一个，则为第一个通过申请的商家
            // 分配账号和结账账号
            merchantaccount.setMerid(application.getAcaamerchant());
            merchantaccount.setMacacc(""+application.getAcaamerchant());
            String password = new Md5Hash("111111", merchantaccount.getMacid(), 3).toString();
            merchantaccount.setMacpasswd(password);
            merchantaccount.setMacacctype(1);
            merchantaccount.setMacenable(true);
            merchantaccount.setMaccumacc(merchantaccount.getMerid());
            merchantaccountMapper.insertSelective(merchantaccount);
        }
        //发送邮件
        System.out.println(merchantaccount + "hehe");
        return merchantaccount;
    }

    @Override
    public void applicationDisagree(int id) {
        Application application = new Application();
        application.setAcaid(id);
        application.setAcastat("未通过");
        applicationMapper.updateByPrimaryKeySelective(application);
        Merchant merchant = new Merchant();
        merchant.setMerid(id);
        merchant.setMerappstat(false);
        merchantMapper.updateByPrimaryKeySelective(merchant);
    }


    //发送消息给商家
    public Merchantaccount sendMessage(Merchantaccount merchantaccount){

        return null;
    }



    @Override
    public List<Merchantinfomodified> findAllMerchantModified() {

        return null;
    }

    @Override
    public Merchantinfo findMerchantModified(int id) {
        return null;
    }

    @Override
    public boolean updateModifiedState(int id, boolean state) {
        return false;
    }

}
