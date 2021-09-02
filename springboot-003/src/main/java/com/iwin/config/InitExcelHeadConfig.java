package com.iwin.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.config
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-20 10:30
 **/

@Component
public class InitExcelHeadConfig implements CommandLineRunner {

  static  Map<Integer, String> head = new LinkedHashMap<>();
    @Override
    public void run(String... args) throws Exception {
        head.put(0, "字符串标题");
        head.put(1, "日期标题");
        head.put(2, "数字标题1");
    }
}
