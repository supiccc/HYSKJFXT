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

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MerchantdetailMapper merchantdetailMapper;

    @Override
    public List<Application> findAllApplications(String state) {
        //查询所有状态为未处理的申请，并返回
        List<Application> applicationList = applicationMapper.findAllApplications(state);

        return applicationList;
    }

    @Override
    public Merchantdetail findApplicationById(int id) {
        //查询商家编号为id的商家资料，返回
        return merchantdetailMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Merchantaccount applicationAgree(int id,int operator) {
        //将编号为id的申请信息设置为已通过
        Application application = new Application();
        application.setAcaid(id);
        application.setAcastat("已通过");
        application.setAcareallo(operator);
        application.setAcareatime(new Date());
        applicationMapper.updateByPrimaryKeySelective(application);

        //获取整个申请信息
        application = applicationMapper.selectByPrimaryKey(id);

        //将入盟申请的入盟商家的申请状态设置为true
        Merchant merchant = new Merchant();
        merchant.setMerid(application.getAcaamerchant());
        merchant.setMerappstat(true);
        merchantMapper.updateByPrimaryKeySelective(merchant);


        Merchantaccount merchantaccount = new Merchantaccount();

        //查找入盟商家的详细信息
        Merchantdetail merchantdetail = merchantdetailMapper.selectByPrimaryKey(application.getAcaamerchant());

        merchantaccount.setMerid(application.getAcaamerchant());
        merchantaccount.setMacacc(merchantdetail.getMerphone());
        String password = new Md5Hash("111111", merchantaccount.getMacacc(), 3).toString();
        merchantaccount.setMacpasswd(password);
        merchantaccount.setMacacctype(1);
        merchantaccount.setMacenable(true);

        //如果申请商家和入盟商家不是同一个，则为同系统的
        if(application.getAcaamerchant()!= null &&
           application.getAcaamerchant() != application.getAcamerchant() &&
           application.getAcamerchant()!= null){
            //分配结账账号为顶级编号
            Merchantaccount merchantaccount1 = merchantaccountMapper.selectByPrimaryKey(application.getAcamerchant());
            merchantaccount.setMaccumacc(merchantaccount1.getMaccumacc());
            merchantaccountMapper.insertSelective(merchantaccount);
        }else { //如果申请商家和入盟商家是同一个，则为第一个通过申请的商家
            // 分配结账账号
            merchantaccount.setMaccumacc(merchantaccount.getMerid());
            merchantaccountMapper.insertSelective(merchantaccount);
        }

        merchantdetail = merchantdetailMapper.selectByPrimaryKey(application.getAcaamerchant());
        //发送短信
        try {
            String result = com.scau.hyskjf.util.sms.PassSMS.pass(merchantdetail.getMerphone(), merchantdetail.getMerprincipal(),
                                                                  merchantdetail.getMername(),merchantaccount.getMacacc());
            return merchantaccount;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Merchantdetail applicationDisagree(int id,int operator) {
        Application application = new Application();
        application.setAcaid(id);
        application.setAcastat("未通过");
        application.setAcareallo(operator);
        application.setAcareatime(new Date());
        applicationMapper.updateByPrimaryKeySelective(application);
        application = applicationMapper.selectByPrimaryKey(id);
        Merchant merchant = new Merchant();
        merchant.setMerid(application.getAcaamerchant());
        merchant.setMerappstat(false);
        merchantMapper.updateByPrimaryKeySelective(merchant);

        Merchantdetail merchantdetail = merchantdetailMapper.selectByPrimaryKey(application.getAcaamerchant());
        try {
            String result = com.scau.hyskjf.util.sms.AuditSMS.nopass(merchantdetail.getMerphone(), merchantdetail.getMerprincipal(),
                                                                     merchantdetail.getMername());
            return merchantdetail;
        } catch (Exception e) {
            return null;
        }

    }




    @Override
    public List<MerchantinfomodifiedWithBLOBs> findAllMerchantModified(String state) {


        List<MerchantinfomodifiedWithBLOBs> merchantinfomodifieds = merchantinfomodifiedMapper.findAllMerchantModified(state);
        return merchantinfomodifieds;
    }


    @Override
    public MerchantinfomodifiedWithBLOBs findMerchantModified(int id) {
        MerchantinfomodifiedWithBLOBs merchantinfomodified = merchantinfomodifiedMapper.selectByPrimaryKey(id);
        return merchantinfomodified;
    }

    @Override
    public MerchantinfoWithBLOBs modifiedAgree(int id,int operator) {
        //首先修改申请表的状态，然后修改商家资料表对应的商家信息
        //以历史表的id创建一个实体对象，将其状态设置为"通过"，同时更新数据库
        MerchantinfomodifiedWithBLOBs merchantinfomodifiedWithBLOBs = new MerchantinfomodifiedWithBLOBs();
        merchantinfomodifiedWithBLOBs.setModifiedid(id);
        merchantinfomodifiedWithBLOBs.setExaminestate("通过");
        merchantinfomodifiedMapper.updateByPrimaryKeySelective(merchantinfomodifiedWithBLOBs);
        //查找历史表为id的编号对应的数据信息
        merchantinfomodifiedWithBLOBs = merchantinfomodifiedMapper.selectByPrimaryKey(id);
        //因为两张表的数据项列名基本相同，所以以修改后的历史表对象为参数，修改商家资料表
        merchantinfoMapper.updateByModified(merchantinfomodifiedWithBLOBs);
        //查询修改后的商家资料表，返回
        MerchantinfoWithBLOBs merchantinfoWithBLOBs = merchantinfoMapper.selectByPrimaryKey(merchantinfomodifiedWithBLOBs.getMerid());
        return merchantinfoWithBLOBs;
    }

    @Override
    public MerchantinfoWithBLOBs modifiedDisagree(int id,int operator) {
        //首先修改申请表的状态，然后发送站内消息给商家
        //首先修改申请表的状态，然后修改商家资料表对应的商家信息
        //以历史表的id创建一个实体对象，将其状态设置为"不通过"，同时更新数据库
        MerchantinfomodifiedWithBLOBs merchantinfomodifiedWithBLOBs = new MerchantinfomodifiedWithBLOBs();
        merchantinfomodifiedWithBLOBs.setModifiedid(id);
        merchantinfomodifiedWithBLOBs.setExaminestate("不通过");
        merchantinfomodifiedMapper.updateByPrimaryKeySelective(merchantinfomodifiedWithBLOBs);
        merchantinfomodifiedWithBLOBs = merchantinfomodifiedMapper.selectByPrimaryKey(id);
        //发送消息给商家
        String title = "商家资料申请审核结果";
        String content = "很抱歉，您提交的审核未通过，请重新修改";
        int source = operator;
        int destination = merchantinfomodifiedWithBLOBs.getMerid();
        int type = 0;
        Message message = new Message();
        message.setMestitle(title);
        message.setMescontent(content);
        message.setMesdestination(destination);
        message.setMessource(source);
        message.setMestype(type);
        message.setMesread(false);
        messageMapper.insertSelective(message);
        return null;

    }
}
