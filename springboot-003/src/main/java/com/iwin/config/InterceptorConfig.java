package com.iwin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.config
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-19 21:04
 **/

@Configuration
public  class  InterceptorConfig  extends WebMvcConfigurationSupport {

    @Override
    protected  void  addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler( "/**" ).addResourceLocations( "classpath:/static/" );
        super .addResourceHandlers(registry);
    }

}
