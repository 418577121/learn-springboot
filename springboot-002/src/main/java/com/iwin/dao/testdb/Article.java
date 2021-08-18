package com.iwin.dao.testdb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.entity
 * @description: 文章实体
 * @author: DingHaiTing
 * @create_time: 2021-08-17 22:50
 **/
@Data
@Entity
@Table(name = "article")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length = 32)
    private String author;
    @Column(nullable = false, unique = true,length = 32)
    private String title;
    @Column(length = 512)
    private String content;
    private Date createTime;


}
