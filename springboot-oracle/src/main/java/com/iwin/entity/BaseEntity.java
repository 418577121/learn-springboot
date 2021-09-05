package com.iwin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.entity
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-09-02 20:39
 **/

@Data
public class BaseEntity {

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Integer delFlag;
}