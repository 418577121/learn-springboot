package com.iwin.config;

import com.iwin.task.QuartzSimpleTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.config
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-27 08:53
 **/

@Configuration
public class QuartzSimpleConfig {

    // 指定具体的定时任务类
    @Bean
    public JobDetail uploadTaskDetail() {
        return  JobBuilder.newJob(QuartzSimpleTask.class)
                .withIdentity("QuartzSimpleTask")
                .storeDurably().build();
    }
    @Bean
    public Trigger uploadTaskTrigger() {
        //这里设定触发执行的方式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("QuartzSimpleTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
