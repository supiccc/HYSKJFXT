package com.scau.hyskjf.controller;

import com.scau.hyskjf.pojo.CashConsumption;
import com.scau.hyskjf.pojo.CreditConsumption;
import com.scau.hyskjf.pojo.Merchantaccount;
import com.scau.hyskjf.pojo.StoreConsumption;
import com.scau.hyskjf.service.ConsumptionService;
import com.scau.hyskjf.util.json.ResponseCode;
import com.scau.hyskjf.util.json.ResponseJSON;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* 无论执行哪种消费，先判断会员卡号是否存在，储值和积分消费还要再判断消费密码是否正确，储值或积分是否足够（失败则返回不同的错误码）
* （1）现金消费登记：页面提供会员卡卡号输入框、消费金额输入框
*  会员刷卡后，商家输入消费金额完成会员消费的登记。这里应该也需要将扣减的金额按照积分比例划入积分
* （2）储值刷卡消费登记：
*  会员刷卡后，会员输入消费密码后系统根据当前商家编号扣减会员在当前商家充值的金额，并将扣减的金额按照积分比例划入积分。
*  消费成功即点击确认按钮，系统根据商家的设置向会员发送消费通知信息。
* （3）积分消费登记：
*
* */
@RestController
@RequestMapping("/memberConsumption")
public class MemberConsumptionController {

    @Autowired
    ConsumptionService consumptionService;

    /*(已测试)
    * 现金消费：
    * 输入：会员卡号String mcid + 消费金额 Float money + 商家账号编号 macid
    *
    * 输出:
    * 成功时：code=0，同时返回获得的积分Float getCredit
    * 失败结果：code=-2时表示 "会员卡号错误"。code=-1, "其他错误";
    * */
    @RequestMapping("/cashConsumption")
    public ResponseJSON cashConsumption(String mcid ,Float money){
        try {
            Integer macid = ((Merchantaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMacid();
            CashConsumption cashConsumption = consumptionService.cashConsumptionCheck(mcid , money);
            if(cashConsumption.getCheckResult().equals(0)){
                Float getCredit =consumptionService.cashCompute(cashConsumption,macid);//积分添加、消费历史添加等操作
                return new ResponseJSON(ResponseCode.SUCCESS,getCredit);//返回获得的积分
            }
            else if(cashConsumption.getCheckResult().equals(-2)){//会员卡号错误
                return new ResponseJSON(ResponseCode.ERRORCARD);
            }
            else{
                return new ResponseJSON((ResponseCode.WARN));//其他错误
            }
        }
        catch (Exception e){
            //e.printStackTrace();
            return new ResponseJSON((ResponseCode.WARN));
        }
    }

    /* （已测试）
     * 储值消费：
     * 输入：会员卡号String mcid + 消费金额 Float money + 消费密码 String pwd + 商家账号编号 macid
     *
     * 输出:
     * 成功时：code=0，同时返回剩余储值Float leftStore
     * 失败结果：code=-2时表示 "会员卡号错误"。code=-3, "消费密码错误"。code=-5, "储值余额不足";code=-1, "其他错误";
     * */
    @RequestMapping("/storeConsumption")
    public ResponseJSON storeConsumption(String mcid ,Float money, String pwd){
        try {
            Integer macid = ((Merchantaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMacid();
            StoreConsumption storeConsumption = consumptionService.storeConsumptionCheck(mcid , money, pwd);
            if(storeConsumption.getCheckResult().equals(0)){
                Float leftStore =consumptionService.storeCompute(storeConsumption,macid);//执行储值扣除、消费历史添加等操作
                return new ResponseJSON(ResponseCode.SUCCESS,leftStore);//返回会员剩余储值
            }
            else if(storeConsumption.getCheckResult().equals(-2)){//会员卡号错误
                return new ResponseJSON(ResponseCode.ERRORCARD);
            }
            else if(storeConsumption.getCheckResult().equals(-3)){//消费密码错误
                return new ResponseJSON(ResponseCode.ERRORSHOPPWD);
            }
            else if(storeConsumption.getCheckResult().equals(-5)){//储值不足
                return new ResponseJSON(ResponseCode.LACKSTORE);
            }
            else{
                return new ResponseJSON((ResponseCode.WARN));//其他错误
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseJSON((ResponseCode.WARN));
        }
    }

    /*（已测试）
     * 积分消费：
     * 输入：会员卡号String mcid + 消费金额 Float money + 消费密码 String pwd + 商家账号编号 macid
     *
     * 输出:
     * 成功时：code=0，同时返回剩余积分Float leftCredit
     * 失败结果：code=-2时表示 "会员卡号错误"。code=-3, "消费密码错误"。code=-4, "积分不足"。 code=-5, "储值余额不足";code=-1, "其他错误";
     * */
    @RequestMapping("/creditConsumption")
    public ResponseJSON creditConsumption(String mcid ,Float money, String pwd){
        try {
            Integer macid = ((Merchantaccount)SecurityUtils.getSubject().getSession().getAttribute("user")).getMacid();
            CreditConsumption creditConsumption = consumptionService.creditConsumptionCheck(mcid , money, pwd);
            if(creditConsumption.getCheckResult().equals(0)){
                Float leftCredit =consumptionService.creditCompute(creditConsumption,macid);//执行积分扣除、消费历史添加等操作
                return new ResponseJSON(ResponseCode.SUCCESS,leftCredit);//返回会员剩余积分
            }
            else if(creditConsumption.getCheckResult().equals(-2)){//会员卡号错误
                return new ResponseJSON(ResponseCode.ERRORCARD);
            }
            else if(creditConsumption.getCheckResult().equals(-3)){//消费密码错误
                return new ResponseJSON(ResponseCode.ERRORSHOPPWD);
            }
            else if(creditConsumption.getCheckResult().equals(-4)){//积分不足
                return new ResponseJSON(ResponseCode.LACKCREDIT);
            }
            else{
                return new ResponseJSON((ResponseCode.WARN));
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseJSON((ResponseCode.WARN));
        }
    }
}
