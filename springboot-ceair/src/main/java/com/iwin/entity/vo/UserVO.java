package com.iwin.entity.vo;

import lombok.Data;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.entity.vo
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-09-05 11:21
 **/
@Data
public class UserVO {
    private String loginName; //账户名
    private String userName; //姓名
    private String phoneNumber; //手机号
    private String deptName; //部门
    private String status; //状态
    private String userType; //类型
    private String isOa; //判断是否是oa用户
    private String parentId; //父部门id
}
