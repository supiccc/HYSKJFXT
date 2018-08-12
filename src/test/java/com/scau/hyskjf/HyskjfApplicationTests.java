package com.scau.hyskjf;

import com.scau.hyskjf.pojo.Admin;
import com.scau.hyskjf.service.AuthenticationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HyskjfApplicationTests {
    @Autowired
    AuthenticationService authenticationService;

    @Test
    public void contextLoads() {
        Admin a = authenticationService.findAdminByacc("13602800453");
    }

}
