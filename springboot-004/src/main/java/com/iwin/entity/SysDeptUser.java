package com.iwin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门和用户关联表
 * </p>
 *
 * @author iwin
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDeptUser extends Model<SysDeptUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    private BigDecimal deptId;

    /**
     * 用户ID
     */
    private BigDecimal userId;


    @Override
    protected Serializable pkVal() {
        return this.deptId;
    }

}
