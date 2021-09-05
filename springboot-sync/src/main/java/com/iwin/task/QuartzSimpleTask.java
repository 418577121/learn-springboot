package com.iwin.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.task
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-27 08:50
 **/

public class QuartzSimpleTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz简单的定时任务执行时间："+new Date().toLocaleString());
    }
}
