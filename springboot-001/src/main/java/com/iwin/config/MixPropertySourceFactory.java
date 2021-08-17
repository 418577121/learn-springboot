package com.iwin.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.Properties;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.config
 * @description: 支持两只配置文件格式
 * @author: DingHaiTing
 * @create_time: 2021-08-17 15:22
 **/

public class MixPropertySourceFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
       // return (name != null ? new ResourcePropertySource(name, resource) : new ResourcePropertySource(resource));
        String sourceName = name != null ? name : resource.getResource().getFilename();

        if (sourceName != null && (sourceName.endsWith(".yml") || sourceName.endsWith("yaml"))) {
         Properties properties = loadYml(resource);
         return new PropertiesPropertySource(sourceName, properties);
        } else {
            return super.createPropertySource(name, resource);
        }
    }

    private Properties loadYml(EncodedResource resource) {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource.getResource());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
