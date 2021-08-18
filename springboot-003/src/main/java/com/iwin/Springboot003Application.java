package com.iwin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iwin.mapper")
public class Springboot003Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot003Application.class, args);
    }

}
