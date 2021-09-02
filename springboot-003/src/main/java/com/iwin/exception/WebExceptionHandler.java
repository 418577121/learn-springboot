package com.iwin.exception;

import com.alibaba.excel.exception.ExcelAnalysisException;
import com.iwin.common.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.exception
 * @description: 全局异常处理器
 * @author: DingHaiTing
 * @create_time: 2021-08-19 09:46
 **/

@RestControllerAdvice
@Slf4j
public class WebExceptionHandler {
    //处理程序员主动转换的自定义异常
    @ExceptionHandler(CustomException.class)
    public AjaxResponse customerException(CustomException e) {
        if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            //400异常不需要持久化，将异常信息以友好的方式告知用户就可以
            //TODO 将500异常信息持久化处理，方便运维人员处理
        }
        log.info("自定义异常"+ e);
        e.printStackTrace();
        return AjaxResponse.error(e);
    }

    //处理程序员在程序中未能捕获（遗漏的）异常
    @ExceptionHandler(Exception.class)
    public AjaxResponse exception(Exception e) {
        //TODO 将异常信息持久化处理，方便运维人员处理
        log.info("未知异常"+ e);
        e.printStackTrace();
        return AjaxResponse.error(new CustomException(
                CustomExceptionType.OTHER_ERROR));
    }

    /**
     * 全局校验参数
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResponse handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                fieldError.getDefaultMessage()));
    }

    /**
     * 全局校验参数
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxResponse handleBindException(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                fieldError.getDefaultMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public AjaxResponse handleIllegalArgumentException(IllegalArgumentException e) {
        return AjaxResponse.error(
                new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                        e.getMessage())
        );
    }


    @ExceptionHandler(ExcelAnalysisException.class)
    @ResponseBody
    public AjaxResponse handleIllegalArgumentException(ExcelAnalysisException e) {
        return AjaxResponse.error(
                new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                        e.getCause().getMessage())
        );
    }
}
