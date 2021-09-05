package com.iwin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iwin.mapper")
public class SpringbootOracleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOracleApplication.class, args);
    }

}
