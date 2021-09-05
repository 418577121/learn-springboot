package com.iwin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iwin.mapper")
public class SpringbootCeairApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCeairApplication.class, args);
    }

}
