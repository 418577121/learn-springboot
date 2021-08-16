package com.iwin.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.common
 * @description: 统一返回结果
 * @author: DingHaiTing
 * @create_time: 2021-08-16 10:59
 **/
@Data
@AllArgsConstructor
@Builder
public class AjaxResponse {
    private boolean isOk;
    private Integer code;
    private String message;
    private Object data;

    public AjaxResponse() {
    }

    /**
     *  请求成功调用
     * @param data
     * @return
     */
    public static AjaxResponse success(Object data) {
     return AjaxResponse.builder()
             .isOk(true).code(200).message("请求成功").data(data)
             .build();
    }



    public static AjaxResponse success() {
        return AjaxResponse.builder()
                .isOk(true).code(200).message("请求成功")
                .build();
    }
    /**
     *   自定义返回 message
     * @param data
     * @param message
     * @return
     */
    public static AjaxResponse success(Object data, String message) {
        return AjaxResponse.builder()
                .isOk(true).code(200).message(message).data(data)
                .build();
    }

}
