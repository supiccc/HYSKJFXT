package com.scau.hyskjf.controller;

import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Creditsubmit;
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

        List<Creditsubmit> creditsubmits = consumeCreditService.findAllSubmit(null);

        return new ResponseJSON(ResponseCode.SUCCESS,creditsubmits);
    }

    //已上缴情况浏览
    @RequestMapping("/submited/list")
    public ResponseJSON browseSubmited(){
        List<Creditsubmit> creditsubmits = consumeCreditService.findAllSubmit(true);
        return new ResponseJSON(ResponseCode.SUCCESS,creditsubmits);
    }

    //未上缴情况浏览
    @RequestMapping("/unsubmited/list")
    public ResponseJSON browseUnsubmit(){
        List<Creditsubmit> creditsubmits = consumeCreditService.findAllSubmit(false);
        return new ResponseJSON(ResponseCode.SUCCESS,creditsubmits);
    }

    //上缴情况修改
    @RequestMapping("/submit/update/{id}")
    public ResponseJSON UpdateCsInfo(@ModelAttribute("user")Admin admin,@PathVariable int id,
                                     @RequestParam(value = "state",required=true) boolean state){

        boolean flag = consumeCreditService.updateState(id,state);
        if(flag){
            return new ResponseJSON(ResponseCode.WARN,false);
        }else {
            return new ResponseJSON(ResponseCode.SUCCESS,true);
        }
    }
}
