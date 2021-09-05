package com.iwin.entity.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.iwin.utils.SheetName;
import lombok.Data;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.entity.excel
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-09-05 13:41
 **/
@SheetName("用户数据")
@Data
public class UserExcel {
    @ExcelProperty("账户名")
    private String loginName; //账户名
    @ExcelProperty("姓名")
    private String userName; //姓名
    @ExcelProperty("手机号")
    private String phoneNumber; //手机号
    @ExcelProperty("部门")
    private String deptName; //部门
    @ExcelProperty("状态")
    private String status; //状态
    @ExcelProperty("类型")
    private String userType; //类型
    @ExcelProperty("渠道")
    private String channels;
    @ExcelProperty("角色")
    private String roles;
    @ExcelIgnore
    private String isOa; //判断是否是oa用户
    @ExcelIgnore
    private String parentId; //父部门id
}
