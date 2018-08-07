package com.scau.hyskjf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.scau.hyskjf.dao")
public class HyskjfApplication {

    public static void main(String[] args) {
        SpringApplication.run(HyskjfApplication.class, args);
    }
}
