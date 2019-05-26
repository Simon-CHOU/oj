package com.simon.oj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.simon.oj.dao")
public class OjApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OjApplication.class, args);
    }

}
