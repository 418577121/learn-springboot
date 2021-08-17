package com.iwin.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.entity
 * @description: 员工实体
 * @author: DingHaiTing
 * @create_time: 2021-08-17 15:36
 **/

@Data
@Configuration
@PropertySource(value = "classpath:employee.properties", encoding = "utf-8")
public class Employee {

    // SPEL
    @Value("#{'${employee.names}'.split('\\|')}")
    private List<String> employeeNames;

    @Value("#{'${employee.names}'.split('\\|')[0]}")
    private List<String> firstEmployeeNames;

    @Value("#{${employee.age}}")
    private Map<String, Integer> employeeAge;

    @Value("#{${employee.age}['two']}")
    private String twoEmployeeAge;

    @Value("#{${employee.age}['two'] ?: '99'}")
    private String fiveEmployeeAge;

    @Value("#{systemProperties['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['user.dir']}")
    private String userDir;


}
