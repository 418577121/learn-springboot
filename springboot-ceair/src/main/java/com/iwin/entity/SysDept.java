package com.iwin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author iwin
 * @since 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDept extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId(type = IdType.AUTO)
    private String deptId;

    /**
     * 父部门id
     */
    private String parentId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门状态（0正常 1停用）
     */
    private Integer status;


    /**
     * 创建者
     */
    private String createId;

    /**
     * 更新者
     */
    private String updateId;





}
