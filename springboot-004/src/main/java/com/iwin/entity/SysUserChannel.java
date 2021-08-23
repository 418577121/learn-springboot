package com.iwin.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户和渠道关联表
 * </p>
 *
 * @author iwin
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserChannel extends Model<SysUserChannel> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private BigDecimal userId;

    /**
     * 渠道号字符串
     */
    private String channel;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
