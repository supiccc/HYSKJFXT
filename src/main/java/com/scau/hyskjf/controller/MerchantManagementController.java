package com.scau.hyskjf.controller;

import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.pojo.Merchantdetail;
import com.scau.hyskjf.pojo.MerchantdetailWithBLOBs;
import com.scau.hyskjf.pojo.MerchantinfoWithBLOBs;
import com.scau.hyskjf.service.MerchantManagementService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MerchantManagement")
public class MerchantManagementController {

    @Autowired
    private MerchantManagementService merchantManagementService;
    //商家查询，浏览联盟内商家，查询商家
    @RequestMapping("/query/list")
    public ResponseJSON findAllMerchant(){

        List<MerchantdetailWithBLOBs> merchandetails = merchantManagementService.findAllMerchant();
        return new ResponseJSON(ResponseCode.SUCCESS,merchandetails);
    }

    //查询商家，可按条件模糊查询（商家名称、所在省、市、区、是否为推荐商家、是否为首页显示商家）
    @RequestMapping("/query")
    public ResponseJSON queryMerchant(String merName, String province,String city, String area,
                                      String type,Integer merrecommend,Integer isindex){

        System.out.println(merName);
        System.out.println(province);

        List<MerchantdetailWithBLOBs> merchantdetails = merchantManagementService.findMerchantDetailByWord
                (merName, province, city, area,type,merrecommend,isindex);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantdetails);
    }


    //查看单个商家
    @RequestMapping("/merchantinfo/{id}")
    public ResponseJSON findMerchantById(@PathVariable int id){
        MerchantinfoWithBLOBs merchantinfoWithBLOBs = merchantManagementService.findMerchantById(id);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantinfoWithBLOBs);
    }

    //查看商家所有账户信息
    @RequestMapping("/merchantAllAccount/{id}")
    public ResponseJSON findAllAccounts(@PathVariable(name = "id") int merid){
        List<Merchantaccount> merchantaccounts = merchantManagementService.findMerchantAccountsById(merid);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantaccounts);
    }
    //查看单个账户信息
    @RequestMapping("/merchantAccount/{id}")
    public ResponseJSON findAccountById(@PathVariable(name = "id") int macid){
        Merchantaccount merchantaccount = merchantManagementService.findMerchantAccountById(macid);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantaccount);
    }


    //禁用商家账号(包括子账号)
    @RequestMapping("/merchantAccount/{id}/forbid")
    public ResponseJSON forbidMerchantAccounts(@PathVariable(name = "id") int merid){
        merchantManagementService.forbidMerchantAccounts(merid);
        return new ResponseJSON(ResponseCode.SUCCESS,"成功");
    }
    //启用商家账号
    @RequestMapping("/merchantAccount/{id}/enable")
    public ResponseJSON enableMerchant(@PathVariable(name = "id") int merid){
        merchantManagementService.enableMerchantAccounts(merid);
        return new ResponseJSON(ResponseCode.SUCCESS,"hehe");
    }


    //积分划拨比列设置
    @RequestMapping("/credit/reset/{id}")
    public ResponseJSON resetCredit(@PathVariable(name = "id") int merid){
        return null;
    }


    //设置为推荐商家
    @RequestMapping("/setRecommend/{id}")
    public ResponseJSON setRecommend(@PathVariable int id){

        Merchantdetail merchantdetail = merchantManagementService.setRecommend(id);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantdetail);
    }
    //取消推荐商家设置
    @RequestMapping("/setUnrecommend/{id}")
    public ResponseJSON setUnrecommend(@PathVariable int id){
        Merchantdetail merchantdetail = merchantManagementService.setUnrecommend(id);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantdetail);
    }

    //设置为首页显示
    @RequestMapping("/setIndex/{id}")
    public ResponseJSON setIndex(@PathVariable int id){
        Merchantdetail merchantdetail = merchantManagementService.setIndex(id);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantdetail);
    }
    //设置不为首页显示
    @RequestMapping("/setNotIndex/{id}")
    public ResponseJSON setNotIndex(@PathVariable int id){
        Merchantdetail merchantdetail = merchantManagementService.setNotIndex(id);
        return new ResponseJSON(ResponseCode.SUCCESS,merchantdetail);
    }



}
