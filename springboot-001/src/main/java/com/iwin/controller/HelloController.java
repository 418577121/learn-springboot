package com.iwin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.com
 * @description: 测试001
 * @author: DingHaiTing
 * @create_time: 2021-08-16 09:16
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello world 111111" + name;
    }
}
