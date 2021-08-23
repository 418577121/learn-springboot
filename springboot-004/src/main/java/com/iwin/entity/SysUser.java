package com.iwin.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author iwin
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
//@JsonInclude(JsonInclude.Include.NON_NULL) // 值为null 时不返回
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private BigDecimal userId;

    private String userName;

    private String status;

    private String delFlag;

    private String createBy;

    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
