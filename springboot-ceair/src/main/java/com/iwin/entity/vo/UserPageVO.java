package com.iwin.entity.vo;

import lombok.Data;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.entity.vo
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-09-05 12:14
 **/

@Data
public class UserPageVO {
    private Integer pageNum;
    private Integer pageSize;
    private String loginName; //账户名
    private String userName; //姓名
    private String phoneNumber; //手机号
    private String deptName; //部门id
    private String status; //状态
}
