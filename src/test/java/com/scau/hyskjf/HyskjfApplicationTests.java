package com.scau.hyskjf;

import com.scau.hyskjf.dao.ConsumedetailMapper;
import com.scau.hyskjf.dao.CredithistoryviewMapper;
import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Consumedetail;
import com.scau.hyskjf.pojo.Credithistoryview;
import com.scau.hyskjf.service.AuthenticationService;
import com.scau.hyskjf.service.MemberCenterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HyskjfApplicationTests {
    @Autowired
    MemberCenterService memberCenterService;

    @Test
    public void contextLoads() {

    }

}
