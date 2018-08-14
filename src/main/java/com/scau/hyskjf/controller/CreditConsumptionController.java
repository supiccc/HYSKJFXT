package com.scau.hyskjf.controller;


import com.scau.hyskjf.pojo.Creditconsume;
import com.scau.hyskjf.service.CreditsumptionService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//积分消费管理控制器
@RestController
@RequestMapping("/creditconsume")
public class CreditConsumptionController {

    @Autowired
    private CreditsumptionService creditsumptionService;

    //查看会员积分消费记录
    public ResponseJSON findAllCreditconsume(){


        return null;

    }


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
        if(stateType == null && timeType != null){
            creditconsumes = creditsumptionService.findAllCreditsoncumeOrderByTime(timeType);
        }
         else if(stateType != null && timeType != null){
            creditconsumes = creditsumptionService.findAllCreditsoncumeOrderByStateAndTime(timeType, stateType);
        }
        else if(stateType != null && timeType == null){
            creditconsumes = creditsumptionService.findAllCreditsoncumeOrderByState(stateType);
        }
        else
            creditconsumes = creditsumptionService.findAllCreditsoncume();
        return new ResponseJSON(ResponseCode.SUCCESS,creditconsumes);
    }
    //查看会员积分消费记录、按照处理状态排序


    //查看单个会员积分消费记录
    @RequestMapping("/record/{id}")
    public ResponseJSON findCreaditconsume(int id){
        Creditconsume creditconsume = creditsumptionService.findCreditconsume(id);
        return new ResponseJSON(ResponseCode.SUCCESS,creditconsume);
    }


    //资金下发

    @RequestMapping("/moneyReturn/{creconId}")
    public ResponseJSON returnMoney(@PathVariable int creconId){

        creditsumptionService.updateState(1,creconId);
        return new ResponseJSON(ResponseCode.SUCCESS,null);

    }


    //积分划扣
}
