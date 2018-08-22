package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.dao.*;
import com.scau.hyskjf.pojo.*;
import com.scau.hyskjf.service.MemberCenterService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by supiccc on 2018-08-09 08:53
 */
@Service
public class MemberCenterServiceImpl implements MemberCenterService {
    @Autowired
    MemberaccountMapper memberaccountMapper;

    @Autowired
    CredithistoryviewMapper credithistoryviewMapper;

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    ConsumedetailMapper consumedetailMapper;

    @Autowired
    EvaluationMapper evaluationMapper;

    @Autowired
    ConsumeMapper consumeMapper;

    @Autowired
    ConsumecommentMapper consumecommentMapper;

    @Autowired
    MembercardMapper membercardMapper;

    @Autowired
    MembercarddetailMapper membercarddetailMapper;

    @Autowired
    MemberandcardMapper memberandcardMapper;

    @Autowired
    RechargehistoryMapper rechargehistoryMapper;

    @Autowired
    MemberinfochangeMapper memberinfochangeMapper;

    @Override
    public String forgetPwd(String newPwd, String verficationCode) {
        try {
            if (SecurityUtils.getSubject().getSession().getAttribute("verficationCode").toString().equals(verficationCode)) {
                Memberaccount tmp = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
                Memberaccount m = memberaccountMapper.selectByPrimaryKey(tmp.getMemid());
                m.setMapwd((new Md5Hash(newPwd, m.getMaid(), 3).toString()));
                memberaccountMapper.updateByPrimaryKey(m);
                return "TRUE";
            } else {
                return "INCORRECT VERFICATION CODE";
            }
        } catch (Exception e) {
            return e.toString();
        }
    }


    // 忘记消费密码
    @Override
    public String forgetDealPwd(String oldPwd, String newPwd) {
        try {
            Memberaccount tmp = (Memberaccount)SecurityUtils.getSubject().getSession().getAttribute("user");
            Memberaccount m = memberaccountMapper.selectByPrimaryKey(tmp.getMemid());
            if (m.getMacumpwd().equals(new Md5Hash(oldPwd, m.getMaid(), 3).toString())) {
                m.setMacumpwd((new Md5Hash(newPwd, m.getMaid(), 3).toString()));
                memberaccountMapper.updateByPrimaryKey(m);
                return "TRUE";
            } else {
                return "INCORRECT OLD PASSWORD";
            }
        } catch (Exception e) {
            return e.toString();
        }
    }

    // 显示会员信息
    @Override
    public Map showMember() {
        Memberaccount tmp = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
        Member m = memberMapper.selectByPrimaryKey(tmp.getMemid());
        if (m == null) return null;
        Map result = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(m.getMembirth());
        m.setMembirth(null);
        result.put("Object", m);
        result.put("birth", date);
        return result;
    }

    // 显示积分变动历史
    @Override
    public List<Credithistoryview> showCreditHistory() {
        Memberaccount m = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
        if (m == null) return null;
        return credithistoryviewMapper.selectAll(m.getMemid());
    }


    // 更新会员信息
    @Override
    public Map<String, Object> updateMember(Member member, String birth) throws ParseException {
        Member old = memberMapper.selectByPrimaryKey(member.getMemid());
        if (!insertMemberInfoChange(old)) {
            return null;
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(birth);
        member.setMembirth(date);
        memberMapper.updateByPrimaryKeySelective(member);
        member.setMembirth(null);
        Map<String, Object> result = new HashMap<>();
        result.put("Object", member);
        result.put("Birth", birth);
        return result;
    }

    // 保存旧历史到会员信息变更表
    public boolean insertMemberInfoChange(Member oldmember) {
        Memberinfochange old = new Memberinfochange();
        old.setMemid(oldmember.getMemid());
        old.setMiccer(oldmember.getMemcer());
        old.setMiccerid(oldmember.getMemcerid());
        old.setMicname(oldmember.getMemname());
        old.setMicsex(oldmember.getMemsex());
        old.setMicphone(oldmember.getMemphone());
        old.setMicbirth(oldmember.getMembirth());
        old.setMicadredd(oldmember.getMemadress());
        old.setMicemail(oldmember.getMememail());
        old.setMictime(new Date());
        memberinfochangeMapper.insert(old);
        return true;
    }

    // 查询所有消费记录
    @Override
    public List showConsumedetail() {
        Memberaccount m = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
        if (m == null) return null;
        List<Consumedetail> consumedetails = consumedetailMapper.selectAllBymemID(m.getMemid());
        return FormatConsumedetail(consumedetails);
    }

    // 格式化消费记录时间
    @Override
    public List FormatConsumedetail(List list) {
        ArrayList result = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < list.size(); i++) {
            ConsumedetailFormatTime c = new ConsumedetailFormatTime();
            Consumedetail tmp = (Consumedetail)list.get(i);
            c.setCumid(tmp.getCumid());
            c.setMacid(tmp.getMacid());
            c.setMcpkid(tmp.getMcpkid());
            c.setCummoney(tmp.getCummoney());
            c.setCumway(tmp.getCumway());
            c.setCumcredit(tmp.getCumcredit());
            Date date = tmp.getCumtime();
            c.setDate(simpleDateFormat.format(date));
            c.setCumtime(null);
            c.setMemid(tmp.getMemid());
            c.setMerid(tmp.getMerid());
            c.setMertype(tmp.getMertype());
            c.setMername(tmp.getMername());
            c.setEvabyN(memberaccountMapper.selectByPrimaryKey(tmp.getMemid()).getManame());
            result.add(c);
        }
        return result;
    }

    /*
    * 显示未点评消费记录
    * */
//    @Override
//    public List showNoComment() {
//        Memberaccount m = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
//        if(m == null) return null;
//        return consumecommentMapper.selectByMemID(m.getMemid());
//    }

    /*
    *  进行点评
    *  更新消费记录表状态，点评表插入点评数据
    * */
    @Override
    public String comment(Integer merID, String info, HttpServletRequest request) {
        // 获取登录用户信息
        Memberaccount m = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
        if (m == null) return "nologin";
        List<Consumecomment> consumes = consumecommentMapper.selectByMerAndMem(merID, m.getMemid());
        if (consumes.size() == 0) return "noconsume";
        int i = 0;
        for (i = 0; i < consumes.size(); i++) {
            if (consumes.get(i).getHascomment() == null) {
                continue;
            } else {
                break;
            }
        }
        if (i != consumes.size()) {
            return "hascomment";
        }
//         获取该消费记录信息
//        Consumedetail consumedetail = consumedetailMapper.selectByCumID(consumes.get(i).getCumid());
        // 判断是否用户本人消费记录
//        if (m.getMemid().equals(consumedetail.getMemid())) return "noself";
        // 新建评论对象，并设置属性
        EvaluationWithBLOBs evaluation = new EvaluationWithBLOBs();
        evaluation.setMerid(merID);
        evaluation.setMemid(m.getMemid());
        evaluation.setEvainfo(info);
        evaluation.setEvaip(getIpAddr(request));
        evaluation.setEvatime(new Date());
        evaluation.setEvaenable(true);
        evaluation.setEvaby(m.getMemid());
//        evaluation.setCumid(cumID);
        // 插入数据库
        evaluationMapper.insert(evaluation);
        Consume consume = consumeMapper.selectByPrimaryKey(consumes.get(0).getCumid());
        // 更新消费记录表状态为已评论
        consume.setHascomment(true);
        consumeMapper.updateByPrimaryKey(consume);
        return "success";
    }


    // 获取客户端ip
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    // 查看会员卡
    @Override
    public List showMemberCardInfo() {
        Memberaccount m = (Memberaccount) SecurityUtils.getSubject().getSession().getAttribute("user");
        if(m == null) return null;
        List<Memberaccount> result = membercarddetailMapper.selectByMemID(m.getMemid());
        return result;
    }

    public int addMemberAccount(Member member,String pwd,String shopPwd){
        memberMapper.insert(member);
        Integer id = memberMapper.getMemID();
        Memberaccount memberaccount = new Memberaccount();
        memberaccount.setMemid(id);
        memberaccount.setMaid(member.getMemphone());//登陆账号为手机号
        memberaccount.setManame(member.getMemname());//账户名为姓名
        String pwdMd5 = new Md5Hash(pwd,memberaccount.getMaid(),3).toString();//对账户的密码进行MD5加密
        String shopPwdMd5 = new Md5Hash(shopPwd,memberaccount.getMaid(),3).toString();//对账户的支付密码进行MD5加密
        memberaccount.setMapwd(pwdMd5);
        memberaccount.setMacumpwd(shopPwdMd5);
        memberaccount.setMaenable(true);
        return memberaccountMapper.insert(memberaccount);
    }

    @Override
    public String addMemberCard(Membercard membercard){
        String merID = String.format("%011d",membercard.getMerid());
        String memID = merID+String.format("%011d",membercard.getMemid());
        membercard.setMcid(memID);
        membercardMapper.insert(membercard);
        return memID;
    }

    @Override
    public List<Membercard> queryAllMemCard(Integer merid){
        List<Membercard> list = membercardMapper.queryAllCard(merid);
        return list;
    }

    @Override
    public Membercard queryCardByMcid(String mcid){
        return membercardMapper.queryCardByMcid(mcid);
    }

    @Override
    public int updateCard(Membercard membercard){
        return membercardMapper.updateByPrimaryKeySelective(membercard);
    }

    @Override
    public Memberandcard findMemDetailByCarId(String cardId) {
        return memberandcardMapper.selectByCarId(cardId);
    }

    @Override
        public CreditConsumption rechargeMemberCard(String cardId, float money,Merchantaccount merchantaccount) {

        CreditConsumption record = new CreditConsumption();
        Membercard card =membercardMapper.queryCardByMcidAndMerId(cardId,merchantaccount.getMerid());
        if(card==null||!card.getMcenable()){//检查卡号是否正常
            record.setCheckResult(-2);
            return record;
        }
        membercardMapper.updateMoneyByCarId(cardId,money);

        //查找会员卡信息
        Membercard membercard = membercardMapper.queryCardByMcid(cardId);
        float balance = membercard.getMcbalance();
        Rechargehistory rechargehistory = new Rechargehistory();
        rechargehistory.setRechargemoney(money);
        rechargehistory.setBalance(balance);
        rechargehistory.setMerid(merchantaccount.getMerid());
        rechargehistory.setMacid(merchantaccount.getMacid());
        rechargehistory.setMcid(membercard.getMcid());
        rechargehistory.setRechargetime(new Date());
        rechargehistory.setMemid(membercard.getMemid());
        rechargehistoryMapper.insertSelective(rechargehistory);
       // return memberandcardMapper.selectByCarId(cardId);
        record.setCheckResult(0);
        return record;
    }

    @Override
    public List<Rechargehistory> findRechargeHistoryByCardId(String cardId) {

        return rechargehistoryMapper.findRechargeHistoryByCardId(cardId);
    }

    @Override
    public List<Rechargehistory> findAllRechargeHistory(Integer merid) {
        return rechargehistoryMapper.findRechargeHistoryByMerId(merid);
    }

    @Override
    public Integer getMemIDByPhone(String memphone){
        return memberMapper.queryMemIDByMemphone(memphone);
    }
}
