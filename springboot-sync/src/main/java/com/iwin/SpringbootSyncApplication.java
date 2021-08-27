package com.iwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SpringbootSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSyncApplication.class, args);
    }


    @Scheduled(cron="0/10 * * 26 8 ?")
    public void cronJob(){
        System.out.println("=========================== ...>>cron...." + new Date());
    }

}
