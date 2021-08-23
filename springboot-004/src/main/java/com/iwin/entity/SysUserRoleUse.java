package com.iwin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户和角色关联表(可使用)
 * </p>
 *
 * @author iwin
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserRoleUse extends Model<SysUserRoleUse> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private BigDecimal userId;

    /**
     * 角色ID
     */
    private BigDecimal roleId;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
