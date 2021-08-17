package com.iwin.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.entity
 * @description: 学生实体
 * @author: DingHaiTing
 * @create_time: 2021-08-16 10:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"name","id"})
public class Student  {

    @JsonIgnore // 忽略字段
    private Long id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL) // 值为null 时不返回
    private Integer age;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
