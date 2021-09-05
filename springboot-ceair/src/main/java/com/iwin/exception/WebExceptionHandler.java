package com.iwin.exception;

import com.iwin.response.AjaxResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebExceptionHandler {


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

  @ExceptionHandler(DuplicateKeyException.class)
  @ResponseBody
  public AjaxResponse handleDuplicateKeyException(DuplicateKeyException e) {
    return AjaxResponse.error(
            new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                    "您输入的数据与现有数据重复,请检查之后重新输入")
    );
  }


  @ExceptionHandler(CustomException.class)
  @ResponseBody
  public AjaxResponse customerException(CustomException e) {
    if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
      //400异常不需要持久化，将异常信息以友好的方式告知用户就可以
      //TODO 将500异常信息持久化处理，方便运维人员处理
      e.printStackTrace();
    }
    return AjaxResponse.error(e);
  }

  //处理程序员在程序中未能捕获（遗漏的）异常
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public AjaxResponse exception(Exception e) {
    //TODO 将异常信息持久化处理，方便运维人员处理
    e.printStackTrace();
    return AjaxResponse.error(new CustomException(
            CustomExceptionType.SYSTEM_ERROR,"系统出现未知异常，请联系管理员！"));
  }
}
