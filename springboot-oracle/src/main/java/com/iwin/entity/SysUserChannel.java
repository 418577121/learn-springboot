package com.iwin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户和渠道关联表
 * </p>
 *
 * @author iwin
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserChannel extends Model<SysUserChannel> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private BigDecimal id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 渠道号字符串
     */
    private String channel;

    /**
     * 渠道权限类型(0: 可使用 1:可分配)
     */
    private Integer permsFlag;

    /**
     * 创建者
     */
    private String createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建着
     */
    private String updateId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Integer delFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
