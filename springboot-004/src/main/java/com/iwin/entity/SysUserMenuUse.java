package com.iwin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 管理员和权限关联表(可使用)
 * </p>
 *
 * @author iwin
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserMenuUse extends Model<SysUserMenuUse> {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    private BigDecimal userId;

    /**
     * 权限点id
     */
    private BigDecimal menuId;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
