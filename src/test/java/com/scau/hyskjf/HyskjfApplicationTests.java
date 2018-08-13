package com.scau.hyskjf;

import com.scau.hyskjf.dao.CredithistoryviewMapper;
import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.pojo.Credithistoryview;
import com.scau.hyskjf.service.AuthenticationService;
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
    AuthenticationService authenticationService;
    @Autowired
    CredithistoryviewMapper credithistoryviewMapper;

    @Test
    public void contextLoads() {
        Admin a = authenticationService.findAdminByacc("13602800453");
        List<Credithistoryview> c = credithistoryviewMapper.selectAll(1);
        System.out.println(c.get(0).getMemid());
    }

}
