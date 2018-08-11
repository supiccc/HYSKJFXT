package com.scau.hyskjf.controller;

//该类为审核模块控制类，主要负责商家入盟申请审核和商家展示信息审核

import com.scau.hyskjf.pojo.Application;
import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.pojo.Merchantinfo;
import com.scau.hyskjf.pojo.Merchantinfomodified;
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
        List<Merchantinfomodified> merchantinfomodifieds = examineService.findAllMerchantModified();
        return null;
    }

    //查看单个需要审批的商家修改信息
    @RequestMapping("/modified/{id}")
    public ResponseJSON findMerchantById(){

        return null;
    }

    //商家修改信息通过审核，更新
    @RequestMapping("/modified/{id}/agree")
    public ResponseJSON merchantAgree(){
        return null;
    }

    //不通过，发送站内消息给商家
    @RequestMapping("/modified/{id}/disagree")
    public ResponseJSON merchantDisagree(){
        return null;
    }

}
