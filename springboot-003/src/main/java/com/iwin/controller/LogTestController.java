package com.iwin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.controller
 * @description: 日志测试
 * @author: DingHaiTing
 * @create_time: 2021-08-19 11:14
 **/
@RestController
public class LogTestController {
    private static final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("/test")
    public void test(){
        logger.trace("Trace 日志...");
        logger.debug("Debug 日志...");
        logger.info("Info 日志...");
        logger.warn("Warn 日志...");
        logger.error("Error 日志...");
    }
}
