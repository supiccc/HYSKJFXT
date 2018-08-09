package com.scau.hyskjf.controller;


import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//会员管理控制
@RestController
@RequestMapping("/")
public class MemberManagementController {


    //查询单个会员基本信息
    public ResponseJSON findMemberById(){
        return null;
    }
    //会员基本信息变更
    public ResponseJSON memberupdate(){
        return null;
    }

    //会员变更历史查询,所有会员信息
    public ResponseJSON findAllMemberUpdateHistory(){
        return null;
    }
    //会员变更历史查询,单个会员信息
    public ResponseJSON findMemberUpdateHistory(){
        return null;
    }

    //会员补卡
    public ResponseJSON memberReissue(){
        return null;
    }

    //会员补卡历史查询，所有会员信息

    public ResponseJSON findAllReissueHistory(){
        return null;
    }

    //会员补卡历史查询，单个会员信息

    public ResponseJSON findReissueHistory(){
        return null;
    }



}
