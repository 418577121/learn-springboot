package com.iwin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门信息，和单位多对一
 * </p>
 *
 * @author iwin
 * @since 2021-08-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDept extends Model<SysDept> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String deptId;

    /**
     * 名称
     */
    private String deptName;

    /**
     * 编码，用于递归
     */
    private String deptCode;

    /**
     * 父级部门ID
     */
    private String parDeptId;

    /**
     * 部门领导ID
     */
    private String deptLeader;

    /**
     * 部门描述
     */
    private String deptDesc;

    /**
     * yyyy-mm-dd HH:MM:SS
     */
    private String createTime;

    /**
     * 单位ID
     */
    private String orgId;

    /**
     * 1：正式部门；2：虚拟部门（用于通讯录展示）
     */
    private String deptType;

    /**
     * 排序字段
     */
    private BigDecimal orderId;

    /**
     * 0：无效；1：有效
     */
    private String state;

    /**
     * 企业qqdeptid
     */
    private String bqqDeptId;

    /**
     * 企业qq父类deptid
     */
    private String bqqParDeptId;


    @Override
    protected Serializable pkVal() {
        return this.deptId;
    }

}
