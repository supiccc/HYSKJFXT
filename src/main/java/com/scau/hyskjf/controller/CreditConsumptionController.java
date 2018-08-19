package com.scau.hyskjf.controller;


import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Creditconsume;
import com.scau.hyskjf.pojo.Creditconsumedetail;
import com.scau.hyskjf.service.CreditsumptionService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//积分消费管理控制器
@RestController
@SessionAttributes("user")
@RequestMapping("/creditconsume")
public class CreditConsumptionController {

    @Autowired
    private CreditsumptionService creditsumptionService;

    //查看会员积分消费记录，按照时间排序(0：升序， 1降序)
//    @RequestMapping("/record/list")
//    public ResponseJSON findAllCreditconsumeOrderbyTime(int timeType){
//
//        List<Creditconsume> creditconsumes = creditsumptionService.findAllCreditsoncumeOrderByTime(timeType);
//        return new ResponseJSON(ResponseCode.SUCCESS, creditconsumes);
//    }

    //按照状态和时间排序(0：升序， 1降序, 先按处理状态排序，再按时间排序)
    @RequestMapping("/record/list")
    public ResponseJSON findAllCreditsoncumeOrderByStateAndTime(Integer timeType,Integer stateType){
        List<Creditconsume> creditconsumes;
        List<Creditconsumedetail> creditconsumedetails;
        if(stateType == null && timeType != null){
          //  creditconsumes = creditsumptionService.findAllCreditsoncumeOrderByTime(timeType);
            creditconsumedetails = creditsumptionService.findAllCreditsoncumeDetailOrderByTime(timeType);
        }
         else if(stateType != null && timeType != null){
           // creditconsumes = creditsumptionService.findAllCreditsoncumeOrderByStateAndTime(timeType, stateType);
            creditconsumedetails = creditsumptionService.findAllCreditsoncumeDetailOrderByStateAndTime(timeType, stateType);
        }
        else if(stateType != null && timeType == null){
           // creditconsumes = creditsumptionService.findAllCreditsoncumeOrderByState(stateType);
            creditconsumedetails = creditsumptionService.findAllCreditsoncumeDetailOrderByState(stateType);
        }
        else
            //creditconsumes = creditsumptionService.findAllCreditsoncume();
            creditconsumedetails = creditsumptionService.findAllCreditsoncumeDetail();
        return new ResponseJSON(ResponseCode.SUCCESS,creditconsumedetails);
    }


    //查看单个会员积分消费记录
    @RequestMapping("/record/{id}")
    public ResponseJSON findCreaditconsume(int id){
       // Creditconsume creditconsume = creditsumptionService.findCreditconsume(id);
        Creditconsumedetail creditconsumedetail = creditsumptionService.findCreditconsumeDetail(id);
        return new ResponseJSON(ResponseCode.SUCCESS,creditconsumedetail);
    }


    //资金下发

    @RequestMapping("/moneyReturn/{creconId}")
    public ResponseJSON returnMoney(@ModelAttribute("user") Admin admin, @PathVariable int creconId){

        creditsumptionService.updateState(admin.getAdminid(),creconId);
        return new ResponseJSON(ResponseCode.SUCCESS,null);

    }


    //积分划扣
}
