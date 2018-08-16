package com.scau.hyskjf;

import com.scau.hyskjf.controller.AuthenticationController;
import com.scau.hyskjf.controller.MemberCenterController;
import com.scau.hyskjf.dao.ConsumedetailMapper;
import com.scau.hyskjf.dao.CredithistoryviewMapper;
import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Consumedetail;
import com.scau.hyskjf.pojo.Credithistoryview;
import com.scau.hyskjf.service.AuthenticationService;
import com.scau.hyskjf.service.MemberCenterService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.ThreadContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HyskjfApplicationTests {
//    @Autowired
//    MemberCenterService memberCenterService;
//
//    @Autowired
//    AuthenticationController authenticationController;

//    @Autowired
//    SecurityManager securityManager;

    @Test
    public void contextLoads() {

    }

//    @Test
//    public void login() throws Exception {
////        ThreadContext.bind(securityManager);
////        authenticationController.login("13602800453", "chenchenchen", "member", 0);
////        Assert.assertNotNull(SecurityUtils.getSubject().getPrincipal());
//    }
}
