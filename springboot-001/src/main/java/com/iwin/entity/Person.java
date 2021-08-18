package com.iwin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.entity
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-17 23:43
 **/

@Data
public class Person {
    private Integer id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
