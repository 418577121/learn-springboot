package com.iwin.entity;

import com.iwin.config.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.entity
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-17 15:10
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "school")
@Validated
@PropertySource(value = "classpath:school.yml", factory = MixPropertySourceFactory.class)
public class School {
    private String name;
    private String address;
    @Min(25)
    private Integer age;
}
