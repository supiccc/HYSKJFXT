package com.scau.hyskjf.controller;

//该类为审核模块控制类，主要负责商家入盟申请审核和商家展示信息审核

import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.ExamineService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SessionAttributes("user")
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
        Merchantdetail merchantdetail = examineService.findApplicationById(id);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantdetail);
    }
    //入盟商家审核通过、且分配账号给商家并提醒
    @RequestMapping("application/{id}/agree")

    public ResponseJSON applicationAgree(@ModelAttribute("user") Admin admin, @PathVariable int id){
        System.out.println(admin.getAdminid());
        Merchantaccount merchantaccount = examineService.applicationAgree(id, admin.getAdminid());
        return new ResponseJSON(ResponseCode.SUCCESS,merchantaccount);
    }

    //审核不通过，发送结果给商家
    @RequestMapping("application/{id}/disagree")

    public ResponseJSON applicationDisagree(@ModelAttribute("user") Admin admin,@PathVariable int id){
        Merchantdetail merchantdetail = examineService.applicationDisagree(id,admin.getAdminid());
        return new ResponseJSON(ResponseCode.SUCCESS,merchantdetail);
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
    public ResponseJSON findMerchantById(@PathVariable int id){

        MerchantinfomodifiedWithBLOBs merchantinfomodified = examineService.findMerchantModified(id);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantinfomodified);
    }

    //商家修改信息通过审核，更新
    @RequestMapping("/modified/{id}/agree")
    public ResponseJSON merchantAgree(@ModelAttribute("user") Admin admin,@PathVariable int id){
        MerchantinfoWithBLOBs merchantinfoWithBLOBs = examineService.modifiedAgree(id,admin.getAdminid());
        return new ResponseJSON(ResponseCode.SUCCESS,merchantinfoWithBLOBs);
    }

    //不通过，发送站内消息给商家
    @RequestMapping("/modified/{id}/disagree")
    public ResponseJSON merchantDisagree(@ModelAttribute("user") Admin admin,@PathVariable int id){
        examineService.modifiedDisagree(id,admin.getAdminid());
        return new ResponseJSON(ResponseCode.SUCCESS,null);
    }

}
