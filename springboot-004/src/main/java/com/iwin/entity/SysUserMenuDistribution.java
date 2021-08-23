package com.iwin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 管理员和权限点管理表(可分配)
 * </p>
 *
 * @author iwin
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserMenuDistribution extends Model<SysUserMenuDistribution> {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    private BigDecimal userId;

    /**
     * 权限id
     */
    private BigDecimal menuId;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
