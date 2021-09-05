package com.iwin.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author iwin
 * @since 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private String userId;

    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户类型（01:OA用户，02:非OA用户）
     */
    private String userType;

    /**
     * 管理员标识（00:超级管理员，01:一级管理员，02:二级管理员，03:非管理员）
     */
    private String adminFlag;

    /**
     * 身份证号
     */
    private String idNo;

    /**
     * 证件类型
     */
    private BigDecimal idType;

    /**
     * 用户邮箱
     */
    @Pattern(regexp="[a-za-z0-9._%+-]+@[a-za-z0-9.-]+\\.[a-za-z]{2,4}", message="请输入正确的邮件格式")
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    private Integer status;

    /**
     * 最后登陆IP
     */
    private String loginIp;

    /**
     * 最后登陆时间
     */
    private LocalDateTime loginDate;

    /**
     * 创建者
     */
    private String createId;

    /**
     * 归属着
     */
    private String ownerId;


    /**
     * 更新者
     */
    private String updateId;


    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Integer delFlag;


}
