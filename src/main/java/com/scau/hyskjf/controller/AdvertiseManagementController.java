package com.scau.hyskjf.controller;

import com.scau.hyskjf.pojo.Advertise;
import com.scau.hyskjf.service.AdvertiseManagementService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2018/8/15 16:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/advertise")
public class AdvertiseManagementController {

    @Autowired
    private AdvertiseManagementService advertiseManagementService;
    //查看广告内容

    @RequestMapping("/{id}/detail")
    public ResponseJSON lookAdvertiseDetail(@PathVariable int id){

        Advertise advertise = advertiseManagementService.findById(id);
        
        return new ResponseJSON(ResponseCode.SUCCESS,advertise);
    }


    //修改广告内容
    @RequestMapping("/{id}/change")
    public ResponseJSON updateAdvertise(Advertise advertise){
        advertiseManagementService.updateAdvertise(advertise);

        return new ResponseJSON(ResponseCode.SUCCESS,advertise);
    }


    //查看所有广告
    @RequestMapping("/list")
    public ResponseJSON lookAllAdvertise(){
        List<Advertise> advertises = advertiseManagementService.findAll();
        return new ResponseJSON(ResponseCode.SUCCESS,advertises);
    }


    //查看商家对应的所有广告
}
