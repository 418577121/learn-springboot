package com.iwin.exception;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.exception
 * @description: 自定义异常枚举类
 * @author: DingHaiTing
 * @create_time: 2021-08-19 09:22
 **/

public enum CustomExceptionType {

    USER_INPUT_ERROR(400,"您输入的数据错误或您没有权限访问资源！"),
    SYSTEM_ERROR (500,"系统出现异常，请您稍后再试或联系管理员！"),
    OTHER_ERROR(999,"系统出现未知异常，请联系管理员！");

    private Integer code;
    private String desc;

    CustomExceptionType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
