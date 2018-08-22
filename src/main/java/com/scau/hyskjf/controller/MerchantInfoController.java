package com.scau.hyskjf.controller;

import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.BrandLabelService;
import com.scau.hyskjf.service.EmailService;
import com.scau.hyskjf.service.MerchantInfoService;
import com.scau.hyskjf.service.ProductInfoService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* 3.1.1.1.4	商家展示信息维护功能模块
* 使用角色：商家管理员
* （1）商家资料维护MerchantInfo表查询和修改（不能删除，只能由系统管理员删除，商家资料添加只能在商家入盟时添加）
* （2）产品维护ProductInfo表：添加增删查改产品标签
* （3）产品标签维护：增删查改BrandLabel标签表，增删查改产品和标签的多对多关系表LabelHaveProduct
* （4）商家意见反馈发邮件（所有商家账户可用）
* */

@RestController
@RequestMapping("/merchantInfo")
public class MerchantInfoController {
    @Autowired
    MerchantInfoService merchantInfoService;

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    BrandLabelService brandLabelService;

    @Autowired
    EmailService emailService;

    /*（已测试）
     * 根据商家编号merID查询商家资料：
     * 输入：
     * merID商家编号 Integer
     * 返回：
     * 商家资料merchantinfo或失败码
     * （商家编号 merid;+图片 String merimage;+是否为主图 Boolean mermainimage;+联系电话 String mertelphone;+传真 String merfax;+网址 String merurl;+邮箱 String meremail;+联系人 String merprincipal;
+称谓 String merappellation;+职务 String merduty;+手机（必填） String merphone;+星级 Integer merlevel;+邮编 String merpostnum;
+省（已废弃） String merprovince;+市（已废弃） String mercity;+地区（表达地址包括省市） String merarea;+商家介绍String merintroduce;+联系地址 String meradress;
+附件地标 String merlandmark;+会员特惠 String merdiscount;+促销活动 String merdiscountevent;）
     * */
    @RequestMapping(value = "/queryMerInfoByMerID", method = RequestMethod.POST)
    public ResponseJSON queryMerInfoByMerID(Integer merID) {
        try {
            MerchantinfoWithBLOBs merchantinfoWithBLOBs = merchantInfoService.queryByMerID(merID);
            return new ResponseJSON(ResponseCode.SUCCESS, merchantinfoWithBLOBs);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 根据商家名称merName查询商家资料：
     * 输入：
     * merName商家名称 String
     * 返回：
     * 商家资料merchantinfo或失败码
     * */
    @RequestMapping(value = "/queryMerInfoByMerName", method = RequestMethod.POST)
    public ResponseJSON queryMerInfoByMerName(String merName) {
        try {
            MerchantinfoWithBLOBs merchantinfoWithBLOBs = merchantInfoService.queryByMerName(merName);
            return new ResponseJSON(ResponseCode.SUCCESS, merchantinfoWithBLOBs);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 根据商家编号merId更新商家资料(实际是插入修改内容到商家资料变更表merchantInfoModified，系统管理员审核通过后再更新到商家资料表)：
     * 输入：
     * 商家资料类MerchantinfomodifiedWithBLOBs：merid商家编号 Integer+修改项
     * 返回：
     * 成功码或失败码
     * */
    @RequestMapping(value = "/updateMerInfoByID", method = RequestMethod.POST)
    public ResponseJSON updateMerInfoByID(MerchantinfomodifiedWithBLOBs merchantinfomodifiedWithBLOBs) {
        try {
            merchantinfomodifiedWithBLOBs.setExaminestate("未审批");
            merchantInfoService.updateMerInfo(merchantinfomodifiedWithBLOBs);
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 根据商家编号merID查询商家拥有的产品：
     * 输入：
     * 商家编号merID
     * 返回：
     * 商家拥有的所有产品List<Productinfo>
     * */
    @RequestMapping(value = "/queryAllProductByMerID", method = RequestMethod.POST)
    public ResponseJSON queryAllProductByMerID(Integer merid) {
        try {
            List<Productinfo> productinfoList = productInfoService.findMerAllProduct(merid);
            return new ResponseJSON(ResponseCode.SUCCESS, productinfoList);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 添加产品：
     * 输入：
     * 产品类ProductInfo:商家编号merid必须有
     * 返回：
     * 成功码或失败码
     * */
    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public ResponseJSON insertProduct(Productinfo productinfo) {
        try {
            productInfoService.insertProduct(productinfo);
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 修改产品信息：
     * 输入：
     * 产品类ProductInfo:产品编号pduid必须有+任意要修改的内容(除产品编号pduid和商家编号merid)
     * 返回：
     * 成功码或失败码
     * */
    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public ResponseJSON updateProduct(Productinfo productinfo) {
        try {
            productInfoService.updateProduct(productinfo);
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*（已测试）
     * 删除产品信息：
     * 输入：
     * 产品类ProductInfo:产品编号pduID必须有
     * 返回：
     * 成功码或失败码
     * */
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public ResponseJSON deleteProduct(Integer pduid) {
        try {
            productInfoService.deleteProduct(pduid);//先删除有外键关系的标签-产品关系表的信息，再删除产品表的信息
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*****************************************下面是标签的增删查改（全部废除）*****************************************/

    /*
     * 查询所有标签信息：
     * 输入：
     *
     * 返回：
     * 标签列表 List<Brandlabel>
     *
    @RequestMapping(value = "/queryLabel", method = RequestMethod.POST)
    public ResponseJSON queryLabel() {
        try {
            List<Brandlabel> brandlabelList = brandLabelService.queryAllLabel();
            return new ResponseJSON(ResponseCode.SUCCESS, brandlabelList);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*
     * 根据标签类型标签信息：
     * 输入：
     * 标签类型labelType String
     * 返回：
     * 标签列表 List<Brandlabel>
     *
    @RequestMapping(value = "/queryLabelByType", method = RequestMethod.POST)
    public ResponseJSON queryLabelByType(String labelType) {
        try {
            List<Brandlabel> brandlabelList = brandLabelService.queryLabelByType(labelType);
            return new ResponseJSON(ResponseCode.SUCCESS, brandlabelList);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    *
     * 添加标签信息：
     * 输入：
     * 标签类labelType String
     * 返回：
     * 标签列表 List<Brandlabel>
     *
    @RequestMapping(value = "/insertLabel", method = RequestMethod.POST)
    public ResponseJSON insertLabel(Brandlabel brandlabel) {
        try {
            brandLabelService.insertLabel(brandlabel);
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    *
     * 删除标签：
     * 输入：
     * 标签编号labelID Integer
     * 返回：
     * 成功码或失败码
     *
    @RequestMapping(value = "/deleteLabel", method = RequestMethod.POST)
    public ResponseJSON deleteLabel(Integer labelID) {
        try {
            brandLabelService.deleteLabel(labelID);//先删除有外键关系的标签-产品关系表的信息，再删除标签表的信息
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    *
     * 修改标签：
     * 输入：
     * 标签类Brandlabel : 必须有labelID Integer + 修改内容
     * 返回：
     * 成功码或失败码
     *
    @RequestMapping(value = "/updateLabel", method = RequestMethod.POST)
    public ResponseJSON updateLabel(Brandlabel brandlabel) {
        try {
            brandLabelService.updateLabel(brandlabel);
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }*/

    /*********************************下面是标签与产品关系表的增删查(没有改的功能)*********************************/

    /*
     * 为产品添加标签（在LabelHaveProduct产品和标签多对多的关系表添加信息）：
     * 输入：
     * 标签产品关系类Brandlabel : 必须有labelID Integer + 修改内容
     * 返回：
     * 成功码或失败码
     * *
    @RequestMapping(value = "/insertProductLabel", method = RequestMethod.POST)
    public ResponseJSON insertProductLabel(Labelhaveproduct labelhaveproduct) {
        try {
            brandLabelService.insertProductLabel(labelhaveproduct);
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*
     * 删除标签与产品之间的关系：
     * 输入：
     * 标签编号labelID Integer
     * 返回：
     * 成功码或失败码
     * *
    @RequestMapping(value = "/deleteProductLabel", method = RequestMethod.POST)
    public ResponseJSON deleteProductLabel(Labelhaveproduct labelhaveproduct) {
        try {
            brandLabelService.deleteProductLabel(labelhaveproduct);
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }

    /*
     * 根据商家编号merID和标签LabelID查询该商家的标签拥有的所有产品：
     * 输入：
     * 商家编号merID Integer + 标签编号labelID  Integer
     * 返回：
     * Productinfo类
     * *
    @RequestMapping(value = "/queryLabelProduct", method = RequestMethod.POST)
    public ResponseJSON queryLabelProduct(Integer merID, Integer labelID) {
        try {
            List<Productinfo> labelProductList = productInfoService.queryLabelProduct(merID, labelID);
            return new ResponseJSON(ResponseCode.SUCCESS, labelProductList);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }
    */
    /*****************************************下面是意见反馈发邮箱*****************************************/

    /*
     * 意见反馈：
     * 输入：
     * 反馈意见content String
     * 返回：
     * 成功码和失败码
     * */
    @RequestMapping(value = "/feedbackEmail", method = RequestMethod.POST)
    public ResponseJSON feedbackEmail(String content) {
        try {
            emailService.sendSimpleEmail("1961534631@qq.com", "意见反馈", content);//to为收件人，subject为主题，content为内容
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }


    //查询商家详细信息
    @RequestMapping(value = "/submitdetail")
    public ResponseJSON browseSubmitDetail() {
        Integer merid = ((Merchantaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMerid();
        MerchantdetailWithBLOBs merchantdetail = merchantInfoService.findMerchantDetail(merid);
        return new ResponseJSON(ResponseCode.SUCCESS, merchantdetail);
    }

    //积分上缴
    @RequestMapping(value = "/creditsubmit")
    public ResponseJSON creaditSubmit(Float credit, Float money) {
        try {
            Integer merid = ((Merchantaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMerid();
            merchantInfoService.insertCreditSubmit(merid, credit, money);
            return new ResponseJSON(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseJSON(ResponseCode.WARN);
        }
    }
}