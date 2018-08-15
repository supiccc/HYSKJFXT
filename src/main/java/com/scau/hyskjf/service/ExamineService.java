package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.*;

import java.util.List;

public interface ExamineService {

    //查询所有申请入盟商家
    public List<Application> findAllApplications(String state);

    //查询单个申请入盟商家
    public Merchantdetail findApplicationById(int id);

    //同意入盟申请
    public Merchantaccount applicationAgree(int id, int operator);

    //不同意入盟申请
    public Merchantdetail applicationDisagree(int id,int operator);



    //查看所有未处理的商家资料变更历史
    public List<MerchantinfomodifiedWithBLOBs> findAllMerchantModified(String state);

    //查看单个商家资料变更
    public MerchantinfomodifiedWithBLOBs findMerchantModified(int id);

    public MerchantinfoWithBLOBs modifiedAgree(int id,int operator);

    public MerchantinfoWithBLOBs modifiedDisagree(int id,int operator);


}
