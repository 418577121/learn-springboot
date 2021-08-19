package com.iwin.exception;

import com.iwin.common.AjaxResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.exception
 * @description: 数据返回给前端之前做最后一次处理 使http状态码与返回code保持一直
 * @author: DingHaiTing
 * @create_time: 2021-08-19 10:10
 **/

@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        //return returnType.hasMethodAnnotation(ResponseBody.class);
        return true;
    }
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        //如果响应结果是JSON数据类型
        if(mediaType.equalsTypeAndSubtype(
                MediaType.APPLICATION_JSON)){
            if(body instanceof AjaxResponse){
                AjaxResponse ajaxResponse = (AjaxResponse)body;
                if(ajaxResponse.getCode() != 999){ //999 不是标准的HTTP状态码，特殊处理
                    serverHttpResponse.setStatusCode(HttpStatus.valueOf(
                            ajaxResponse.getCode()
                    ));
                }

                System.out.println(body);
                return body;
            }else{
              //  serverHttpResponse.setStatusCode(HttpStatus.OK);
                return AjaxResponse.success(body);
            }

        }


        return body;
    }
}
