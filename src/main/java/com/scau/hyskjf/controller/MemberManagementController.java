package com.scau.hyskjf.controller;


import com.scau.hyskjf.pojo.Member;
import com.scau.hyskjf.pojo.Memberinfochange;
import com.scau.hyskjf.pojo.Reissuedetail;
import com.scau.hyskjf.service.MemberCenterService;
import com.scau.hyskjf.service.MemberManagementService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//会员管理控制
@RestController
@RequestMapping("/memberManagement")
public class MemberManagementController {


    @Autowired
    private MemberManagementService memberManagementService;

    @Autowired
    MemberCenterService memberCenterService;

    //查询单个会员基本信息
    @RequestMapping("/meminfo/{id}")
    public ResponseJSON findMemberById(@PathVariable int id){
       Member member = memberManagementService.findMemberinfoById(id);
        return new ResponseJSON(ResponseCode.SUCCESS,member);
    }
    //会员基本信息变更
    public ResponseJSON memberupdate(){
        return null;
    }

    //会员变更历史查询,所有会员信息
    @RequestMapping("/memberinfochange/list")
    public ResponseJSON findAllMemberUpdateHistory(){
        List<Memberinfochange> memberinfochanges = memberManagementService.findAllMemberinfochange();
        return new ResponseJSON(ResponseCode.SUCCESS,memberinfochanges);
    }
    //会员变更历史查询,单个会员信息
    @RequestMapping("/memberinfochange/{id}")
    public ResponseJSON findMemberUpdateHistory(@PathVariable int id){
        List<Memberinfochange> memberinfochanges = memberManagementService.findchangeById(id);
        return new ResponseJSON(ResponseCode.SUCCESS,memberinfochanges);
    }

    //会员补卡
    public ResponseJSON memberReissue(){
        return null;
    }

    //会员补卡历史查询，所有会员信息
    @RequestMapping("/reissue/list")
    public ResponseJSON findAllReissueHistory(){
        List<Reissuedetail> reissuedetails = memberManagementService.findAllReissue();
        return new ResponseJSON(ResponseCode.SUCCESS,reissuedetails);
    }

    //会员补卡历史查询，单个会员信息

    @RequestMapping("/ressiue/{memid}")
    public ResponseJSON findReissueHistory(@PathVariable int id){
        List<Reissuedetail> reissuedetails = memberManagementService.findReissueByMemid(id);
        return new ResponseJSON(ResponseCode.SUCCESS,reissuedetails);
    }

    /*（已测试）
    * 根据手机号获取会员号
    * 输入：
    * 手机号String memphone
    * */
    @RequestMapping("/getMemidByPhone")
    public ResponseJSON getMemidByPhone(String memphone){
        try{
            Integer memid = memberCenterService.getMemIDByPhone(memphone);
            return new ResponseJSON(ResponseCode.SUCCESS,memid);
        }
        catch(Exception e){
            return new ResponseJSON(ResponseCode.WARN);
        }
    }
}
