package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.ApplicationMapper;
import com.scau.hyskjf.dao.MerchantMapper;
import com.scau.hyskjf.dao.MerchantinfoMapper;
import com.scau.hyskjf.dao.MerchantinfomodifiedMapper;
import com.scau.hyskjf.pojo.Application;
import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.pojo.Merchantinfo;
import com.scau.hyskjf.pojo.Merchantinfomodified;
import com.scau.hyskjf.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Application> findAllApplications() {
        //查询所有状态为未处理的申请，并返回
        List<Application> applicationList = applicationMapper.findAllApplications();
        return applicationList;
    }

    @Override
    public Merchantinfo findApplicationById(int id) {
        //查询商家编号为id的商家资料，返回
        return merchantinfoMapper.findById(id);
    }

    @Override
    public boolean updateMerchantState(int id, boolean state) {
        //修改商家表的入盟申请状态与商家资料表的申请状态
        //审核通过
        if(state == true){
            //修改商家表的状态为true，修改入盟申请表的状态为"通过"。
        }
        //审核不通过
        else{
            //修改商家表的状态为false，修改入盟申请表的状态为"不通过"。

        }

        return true;
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
