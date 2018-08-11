package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Application;
import com.scau.hyskjf.pojo.Merchantinfo;
import com.scau.hyskjf.pojo.Merchantinfomodified;

import java.util.List;

public interface ExamineService {

    //查询所有申请入盟商家
    public List<Application> findAllApplications();

    //查询单个申请入盟商家
    public Merchantinfo findApplicationById(int id);


    //入盟申请状态修改，并发送消息
    public boolean updateMerchantState(int id,boolean state);


    //查看所有未处理的商家资料变更历史
    public List<Merchantinfomodified> findAllMerchantModified();

    //查看单个商家资料变更
    public Merchantinfo findMerchantModified(int id);


    //修改资料变更表状态，并发送消息
    public boolean updateModifiedState(int id,boolean state);

}
