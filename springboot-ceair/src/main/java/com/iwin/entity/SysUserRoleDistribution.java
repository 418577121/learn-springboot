package com.iwin.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 管理员和权限点管理表(可分配)
 * </p>
 *
 * @author iwin
 * @since 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserRoleDistribution extends Model<SysUserRoleDistribution> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 管理员id
     */
    private String userId;

    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 创建着
     */
    private String createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Integer delFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
