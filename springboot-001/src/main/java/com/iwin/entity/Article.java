package com.iwin.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.entity
 * @description: 文章实体
 * @author: DingHaiTing
 * @create_time: 2021-08-17 22:50
 **/
@Data
public class Article {
    private Integer id;
    private String author;
    private String title;
    private String content;
    private Date createTime;


}
