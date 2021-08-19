package com.iwin.exception;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.exception
 * @description: 自定义异常
 * @author: DingHaiTing
 * @create_time: 2021-08-19 09:28
 **/

public class CustomException extends RuntimeException{
    private Integer code;
    private String message;

    private CustomException() {
    }

    public CustomException(CustomExceptionType exceptionType) {
        this.code = exceptionType.getCode();
        this.message = exceptionType.getDesc();
    }

    public CustomException(CustomExceptionType exceptionType, String message) {
        this.code = exceptionType.getCode();
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
