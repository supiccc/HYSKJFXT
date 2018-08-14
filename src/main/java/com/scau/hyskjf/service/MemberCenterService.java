package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Credithistoryview;
import com.scau.hyskjf.pojo.Member;

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
}
