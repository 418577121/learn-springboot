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
//@Schema(title = "统一 返回结果")
public class AjaxResponse {
    //@Schema(title = "请求是否处理成功")
    private boolean isOk;
   // @Schema(title = "请求状态码", example = "200, 400, 500")
    private Integer code;
   // @Schema(title = "请求结果描述信息")
    private String message;
   // @Schema(title = "请求结果响应数据")
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
