package com.scau.hyskjf.controller;

import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.CreditsubmitdetailWithBLOBs;
import com.scau.hyskjf.service.ConsumeCreditService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//消费积分管理
@RestController
@SessionAttributes("user")
@RequestMapping("/consumecredit")
public class ConsumeCreditController {


    @Autowired
    private ConsumeCreditService consumeCreditService;

    //所有上缴情况浏览
    @RequestMapping("/submit/list")
    public ResponseJSON browseCsInfo(){

        List<CreditsubmitdetailWithBLOBs> creditsubmitdetails = consumeCreditService.findAllSubmit(null);

        return new ResponseJSON(ResponseCode.SUCCESS,creditsubmitdetails);
    }

    //已上缴情况浏览
    @RequestMapping("/submited/list")
    public ResponseJSON browseSubmited(){
        List<CreditsubmitdetailWithBLOBs> creditsubmitdetails = consumeCreditService.findAllSubmitWithState(true);
        return new ResponseJSON(ResponseCode.SUCCESS,creditsubmitdetails);
    }

    //未上缴情况浏览
    @RequestMapping("/unsubmited/list")
    public ResponseJSON browseUnsubmit(){
        List<CreditsubmitdetailWithBLOBs> creditsubmitdetails = consumeCreditService.findAllSubmitWithState(false);
        return new ResponseJSON(ResponseCode.SUCCESS,creditsubmitdetails);
    }

    //未处理的上缴情况浏览
    @RequestMapping("/unhandle/list")
    public ResponseJSON browseUnhandle(){
        List<CreditsubmitdetailWithBLOBs> creditsubmitdetails = consumeCreditService.findAllUnhandleSubmit(false);
        return new ResponseJSON(ResponseCode.SUCCESS,creditsubmitdetails);
    }

    //上缴情况修改
    @RequestMapping("/submit/update/{id}")
    public ResponseJSON UpdateCsInfo(@ModelAttribute("user")Admin admin,@PathVariable int id,
                                     @RequestParam(value = "state",required=true) boolean state){

        boolean flag = consumeCreditService.updateState(id,state);
        if(flag){
            return new ResponseJSON(ResponseCode.SUCCESS,"true");
        }else {
            return new ResponseJSON(ResponseCode.WARN,"false");
        }
    }
}
