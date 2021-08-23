package com.iwin.entity;

import java.math.BigDecimal;
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
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDept extends Model<SysDept> {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    private BigDecimal deptId;

    /**
     * 父部门id
     */
    private BigDecimal parentId;

    /**
     * 祖级列表(所有父级id)
     */
    private String ancestors;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 0:不是叶子节点(可继续创建子级部门)，1:是叶子节点(不可创建子级部门)
     */
    private Integer isLeaf;

    /**
     * 层级关系
     */
    private Integer levelTree;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 部门状态（0正常 1停用）
     */
    private Integer status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private Integer delFlag;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.deptId;
    }

}
