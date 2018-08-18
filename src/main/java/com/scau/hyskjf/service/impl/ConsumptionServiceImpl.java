package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.*;
import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.ConsumptionService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {

    @Autowired
    MembercardMapper membercardMapper;

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberaccountMapper memberaccountMapper;

    @Autowired
    MerchantMapper merchantMapper;

    @Autowired
    ConsumeMapper consumeMapper;

    @Autowired
    CredithistoryMapper credithistoryMapper;

    @Autowired
    CreditconsumeMapper creditconsumeMapper;

    @Override
    public CreditConsumption creditConsumptionCheck(String mcID , Float money, String pwd){
        CreditConsumption record = new CreditConsumption();
        Membercard card =membercardMapper.queryCardByMcid(mcID);
        if(card==null||!card.getMcenable()){//检查卡号是否正常
            record.setCheckResult(-2);
            return record;
        }
        Memberaccount memberaccount = memberaccountMapper.selectByPrimaryKey(card.getMemid());
        String uncheckedPwd = new Md5Hash(pwd,memberaccount.getMaid(),3).toString();
        if(!uncheckedPwd.equals(memberaccount.getMacumpwd())){//检查支付密码是否正确
            record.setCheckResult(-3);
            return record;
        }
        Member member = memberMapper.selectByPrimaryKey(card.getMemid());
        Merchant merchant = merchantMapper.selectByPrimaryKey(card.getMerid());
        Float moneyCredit = money/merchant.getMerdicpresent();//消费金额 / 商家设定的积分换钱比例 = 本次消费花费的积分
        if(member.getMemcredit().compareTo(moneyCredit)<0){//检查用户剩余积分是否足够
            record.setCheckResult(-4);
            return  record;
        }
        Float leftCredit = member.getMemcredit()-moneyCredit;
        if(leftCredit<0){
            record.setCheckResult(-4);
            return record;
        }
        record.setMcpkid(card.getMcpkid());
        record.setMerid(card.getMerid());
        record.setMemid(card.getMemid());
        record.setMemcredit(leftCredit);
        record.setChangeCredit(moneyCredit);
        record.setCheckResult(0);
        record.setMoney(money);
        return record;
    }

    @Override
    public Float creditCompute(CreditConsumption creditConsumption,Integer macID){
        /************************修改会员的剩余积分字段**************************/
        Member member = new Member();
        member.setMemid(creditConsumption.getMemid());
        member.setMemcredit(creditConsumption.getMemcredit());//修改为划扣后的积分
        memberMapper.updateByPrimaryKeySelective(member);//修改会员表
        /************************插入消费记录到消费历史表**************************/
        Consume consume = new Consume();
        consume.setMcpkid(creditConsumption.getMcpkid());
        consume.setCummoney(creditConsumption.getMoney());
        consume.setCumway("积分消费");
        consume.setCumcredit(-1*creditConsumption.getChangeCredit());
        consume.setMacid(macID);
        consume.setCumtime(new java.util.Date());
        consumeMapper.insert(consume);
        /************************插入积分变动加到积分历史表**************************/
        Credithistory credithistory = new Credithistory();
        credithistory.setMcpkid(creditConsumption.getMcpkid());
        credithistory.setChcredit(-1*creditConsumption.getChangeCredit());
        credithistory.setChremain(creditConsumption.getMemcredit());
        credithistory.setChtype("积分消费");
        credithistoryMapper.insert(credithistory);
        /************************插入到积分消费统计表*******************************/
        Creditconsume creditconsume = new Creditconsume();
        creditconsume.setMemid(creditConsumption.getMemid());
        creditconsume.setMerid(creditConsumption.getMerid());
        creditconsume.setCredits(creditConsumption.getChangeCredit());
        creditconsume.setValue(creditConsumption.getMoney());
        creditconsume.setHandletime(new java.util.Date());
        creditconsumeMapper.insert(creditconsume);
        /************************返回用户剩余积分***********************************/
        return creditConsumption.getMemcredit();
    }

    @Override
    public StoreConsumption storeConsumptionCheck(String mcID , Float money, String pwd){
        StoreConsumption record = new StoreConsumption();
        Membercard card =membercardMapper.queryCardByMcid(mcID);
        if(card==null||!card.getMcenable()){//检查卡号是否正常
            record.setCheckResult(-2);
            return record;
        }
        Memberaccount memberaccount = memberaccountMapper.selectByPrimaryKey(card.getMemid());
        String uncheckedPwd = new Md5Hash(pwd,memberaccount.getMaid(),3).toString();
        if(!uncheckedPwd.equals(memberaccount.getMacumpwd())){//检查支付密码是否正确
            record.setCheckResult(-3);
            return record;
        }
        Merchant merchant = merchantMapper.selectByPrimaryKey(card.getMerid());
        if(card.getMcbalance().compareTo(money)<0){//检查会员卡上的余额是否足够
            record.setCheckResult(-5);
            return record;
        }
        Float leftStore = card.getMcbalance()-money;
        Float getCredit = money * merchant.getMercumpresent();//消费金额 * 消费积分比例 = 获得积分
        if(leftStore<0){
            record.setCheckResult(-5);
            return record;
        }
        Member member = memberMapper.selectByPrimaryKey(card.getMemid());
        Float remainCredit = member.getMemcredit()+getCredit;//计算获得了积分后的剩余积分
        record.setRemainCredit(remainCredit);
        record.setMcpkid(card.getMcpkid());
        record.setMerid(card.getMerid());
        record.setMemid(card.getMemid());
        record.setMemStore(leftStore);//剩余储值
        record.setChangeCredit(getCredit);//获得的积分
        record.setMercumpresent(merchant.getMercumpresent());//消费积分比例
        record.setCheckResult(0);
        record.setMoney(money);//消费金额
        return record;
    }

    @Override
    public Float storeCompute(StoreConsumption storeConsumption,Integer macID){
        /************************修改会员卡表的剩余储值字段******************************/
        Membercard membercard = new Membercard();
        membercard.setMcpkid(storeConsumption.getMcpkid());
        membercard.setMcbalance(storeConsumption.getMemStore());//修改为划扣后的储值
        membercardMapper.updateByPrimaryKeySelective(membercard);//修改会员卡表
        /************************添加积分到会员表***********************************/
        Member member = new Member();
        member.setMemid(storeConsumption.getMemid());
        member.setMemcredit(storeConsumption.getRemainCredit());
        memberMapper.updateByPrimaryKeySelective(member);
        /************************插入消费记录到消费历史表****************************/
        Consume consume = new Consume();
        consume.setMcpkid(storeConsumption.getMcpkid());
        consume.setCummoney(storeConsumption.getMoney());
        consume.setCumway("储值消费");
        consume.setCumcredit(storeConsumption.getChangeCredit());
        consume.setMacid(macID);
        consume.setCumtime(new java.util.Date());
        consumeMapper.insert(consume);
        /************************插入积分变动加到积分历史表**************************/
        Credithistory credithistory = new Credithistory();
        credithistory.setMcpkid(storeConsumption.getMcpkid());
        credithistory.setChcredit(storeConsumption.getChangeCredit());
        credithistory.setChremain(storeConsumption.getRemainCredit());
        credithistory.setChtype("储值消费");
        credithistoryMapper.insert(credithistory);
        /************************修改商家所欠积分字段*******************************/
        merchantMapper.updateAddCredit(storeConsumption.getMerid(),storeConsumption.getChangeCredit());//在原有的oweCredit字段加上支出积分
        /************************返回用户剩余储值***********************************/
        return storeConsumption.getMemStore();
    }

    @Override
    public CashConsumption cashConsumptionCheck(String mcID , Float money){
        CashConsumption record = new CashConsumption();
        Membercard card =membercardMapper.queryCardByMcid(mcID);
        if(card==null||!card.getMcenable()){//检查卡号是否正常
            record.setCheckResult(-2);
            return record;
        }
        Merchant merchant = merchantMapper.selectByPrimaryKey(card.getMerid());
        Float getCredit = money * merchant.getMercumpresent();
        //System.out.print(card.getMemid());
        Member member = memberMapper.selectByPrimaryKey(card.getMemid());
        //System.out.print(member.getMemcredit());
        //System.out.print(getCredit);
        Float remainCredit = member.getMemcredit()+getCredit;//计算获得了积分后的剩余积分
        record.setRemainCredit(remainCredit);
        record.setMcpkid(card.getMcpkid());
        record.setMerid(card.getMerid());
        record.setMemid(card.getMemid());
        record.setChangeCredit(getCredit);//获得的积分
        record.setMercumpresent(merchant.getMercumpresent());//消费积分比例
        record.setCheckResult(0);
        record.setMoney(money);//消费金额
        return record;
    }

    @Override
    public Float cashCompute(CashConsumption cashConsumption,Integer macID){
        /************************插入消费记录到消费历史表****************************/
        Consume consume = new Consume();
        consume.setMcpkid(cashConsumption.getMcpkid());
        consume.setCummoney(cashConsumption.getMoney());
        consume.setCumway("现金消费");
        consume.setCumcredit(cashConsumption.getChangeCredit());
        consume.setMacid(macID);
        consume.setCumtime(new java.util.Date());
        consumeMapper.insert(consume);
        /************************添加积分到会员表***********************************/
        Member member = new Member();
        member.setMemid(cashConsumption.getMemid());
        member.setMemcredit(cashConsumption.getRemainCredit());
        memberMapper.updateByPrimaryKeySelective(member);
        /************************插入积分变动加到积分历史表**************************/
        Credithistory credithistory = new Credithistory();
        credithistory.setMcpkid(cashConsumption.getMcpkid());
        credithistory.setChcredit(cashConsumption.getChangeCredit());
        credithistory.setChremain(cashConsumption.getRemainCredit());
        credithistory.setChtype("现金消费");
        credithistoryMapper.insert(credithistory);
        /************************修改商家所欠积分字段*******************************/
        merchantMapper.updateAddCredit(cashConsumption.getMerid(),cashConsumption.getChangeCredit());//在原有的oweCredit字段加上支出积分
        /************************返回用户获得的积分***********************************/
        return cashConsumption.getChangeCredit();
    }
}
