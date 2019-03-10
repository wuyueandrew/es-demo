package com.cn.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(Application.class);
        sa.run(args);
    }

}
