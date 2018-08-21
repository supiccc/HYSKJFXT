package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by supiccc on 2018-08-08 16:03
 */
public interface MemberCenterService {
    String forgetPwd(String newPwd, String verficationCode); // 修改登录密码

    String forgetDealPwd(String oldPwd, String newPwd); // 修改交易密码

    List<Credithistoryview> showCreditHistory(); // 读取积分变化数据

    Map showMember(); // 读取用户信息

    Map<String, Object> updateMember(Member member, String birth) throws ParseException; // 更新用户

    List showConsumedetail(); // 显示消费记录

    List FormatConsumedetail(List list); // 格式化消费记录时间

//    List showNoComment(); // 显示未点评消费记录

    String comment(Integer merID, String info, HttpServletRequest request); // 选择某记录进行点评

    List showMemberCardInfo(); // 显示会员卡记录

    int addMemberAccount(Member member,String pwd,String shopPwd);//添加会员用户

    String addMemberCard(Membercard membercard);//添加会员卡

    List<Membercard> queryAllMemCard(Integer merid);//查询某商家发放的所有会员卡

    //List<Membercard> queryCardByMemid(Integer memid);//根据会员id查询会员卡信息

    Membercard queryCardByMcid(String mcid);//根据会员卡号查询会员卡信息

    int updateCard(Membercard membercard);//修改会员卡信息

    Memberandcard findMemDetailByCarId(String cardId);

    CreditConsumption rechargeMemberCard(String cardId, float money,Merchantaccount merchantaccount);

    List<Rechargehistory> findRechargeHistoryByCardId(String cardId);

    List<Rechargehistory> findAllRechargeHistory(Integer merid);

    Integer getMemIDByPhone(String memphone);//根据手机号获得memid
}
