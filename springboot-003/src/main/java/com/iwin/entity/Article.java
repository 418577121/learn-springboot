package com.iwin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

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
    @TableId(value="ID", type= IdType.AUTO)
    private Integer id;
    private String author;
    private String title;
    @NotEmpty(message = "标题不能为空")
    private String content;
    private Date createTime;
}
