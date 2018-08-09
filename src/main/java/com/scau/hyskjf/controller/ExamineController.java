package com.scau.hyskjf.controller;

//该类为审核模块控制类，主要负责商家入盟申请审核和商家展示信息审核

import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examine")
public class ExamineController {



    //查询所有入盟申请商家
    public ResponseJSON findAllApplications(){
        return null;
    }

    //查询单个入盟申请商家
    public ResponseJSON findApplicationById(){
        return null;
    }
    //入盟商家审核通过、且分配账号给商家并提醒
    public ResponseJSON applicationAgree(){
        return null;
    }

    //审核不通过，发送结果给商家
    public ResponseJSON applicationDisagree(){

        return null;
    }


    /**
     * 以下是商家展示信息审核
     */

    //查看所有需要审批的商家修改信息
    public ResponseJSON findAllMerchants(){

        return null;
    }

    //查看单个需要审批的商家修改信息
    public ResponseJSON findMerchantById(){

        return null;
    }

    //商家修改信息通过审核，更新
    public ResponseJSON merchantAgree(){
        return null;
    }

    //不通过，发送站内消息给商家
    public ResponseJSON merchantDisagree(){
        return null;
    }

}
