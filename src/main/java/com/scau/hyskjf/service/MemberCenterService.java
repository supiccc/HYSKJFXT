package com.scau.hyskjf.service;

import com.scau.hyskjf.pojo.Credithistoryview;
import com.scau.hyskjf.pojo.Member;
import java.util.List;

/**
 * Created by supiccc on 2018-08-08 16:03
 */
public interface MemberCenterService {
    String forgetPwd(String newPwd, String verficationCode); // 修改登录密码

    String forgetDealPwd(String oldPwd, String newPwd); // 修改交易密码

    List<Credithistoryview> showCreditHistory(); // 读取积分变化数据

    Member showMember(); // 读取用户信息
}
