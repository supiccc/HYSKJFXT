package com.scau.hyskjf.controller;

//该类为审核模块控制类，主要负责商家入盟申请审核和商家展示信息审核

import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.ExamineService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/examine")
public class ExamineController {


    @Autowired
    private ExamineService examineService;

    //查询所有入盟申请商家
    @RequestMapping("/application/list")
    public ResponseJSON findAllApplications(){
        List<Application> applications = examineService.findAllApplications("未处理");
        if(applications != null) {
            return new ResponseJSON(ResponseCode.SUCCESS, applications);
        }else {
            return new ResponseJSON(ResponseCode.NOTFOUND,null);
        }
    }

    //查询单个入盟申请商家
    @RequestMapping("/application/{id}")
    public ResponseJSON findApplicationById(@PathVariable int id){
        Merchantinfo merchantinfo = examineService.findApplicationById(id);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantinfo);
    }
    //入盟商家审核通过、且分配账号给商家并提醒
    @RequestMapping("application/{id}/agree")

    public ResponseJSON applicationAgree(@PathVariable int id,
                                         @RequestParam(value = "operator",required=true) Integer operator){
        System.out.println(operator);
        Merchantaccount merchantaccount = examineService.applicationAgree(id, operator);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantaccount);
    }

    //审核不通过，发送结果给商家
    @RequestMapping("application/{id}/disagree")

    public ResponseJSON applicationDisagree(@PathVariable int id){
        return null;
    }


    /**
     * 以下是商家展示信息审核
     */

    //查看所有需要审批的商家修改信息
    @RequestMapping("/modified/list")
    public ResponseJSON findAllMerchants(){
        List<MerchantinfomodifiedWithBLOBs> merchantinfomodifieds = examineService.findAllMerchantModified("未处理");
        return new ResponseJSON(ResponseCode.SUCCESS,merchantinfomodifieds);
    }

    //查看单个需要审批的商家修改信息
    @RequestMapping("/modified/{id}")
    public ResponseJSON findMerchantById(@PathVariable int id,
    @RequestParam(value = "operator",required=true) Integer operator){

        MerchantinfomodifiedWithBLOBs merchantinfomodified = examineService.findMerchantModified(id);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantinfomodified);
    }

    //商家修改信息通过审核，更新
    @RequestMapping("/modified/{id}/agree")
    public ResponseJSON merchantAgree(@PathVariable int id,
    @RequestParam(value = "operator",required=true) Integer operator){
        MerchantinfoWithBLOBs merchantinfoWithBLOBs = examineService.modifiedAgree(id,operator);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantinfoWithBLOBs);
    }

    //不通过，发送站内消息给商家
    @RequestMapping("/modified/{id}/disagree")
    public ResponseJSON merchantDisagree(@PathVariable int id,
    @RequestParam(value = "operator",required=true) Integer operator){
        examineService.modifiedDisagree(id,operator);
        return new ResponseJSON(ResponseCode.SUCCESS,null);
    }

}
