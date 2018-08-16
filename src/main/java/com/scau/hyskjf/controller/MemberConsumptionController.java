package com.scau.hyskjf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* （1）现金消费登记：页面提供会员卡卡号输入框、消费金额输入框
*  会员刷卡后，商家输入消费金额完成会员消费的登记。这里应该也需要将扣减的金额按照积分比例划入积分
*（2）储值刷卡消费登记：
*  会员刷卡后，会员输入消费密码后系统根据当前商家编号扣减会员在当前商家充值的金额，并将扣减的金额按照积分比例划入积分。
*  消费成功即点击确认按钮，系统根据商家的设置向会员发送消费通知信息。
*
* */
@RestController
@RequestMapping("/memberConsumption")
public class MemberConsumptionController {

}
