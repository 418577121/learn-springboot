package com.iwin.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import org.apache.ibatis.type.JdbcType;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.config
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-09-02 22:50
 **/

public class MybatisPlusCustomizers implements ConfigurationCustomizer {
    @Override
    public void customize(MybatisConfiguration configuration) {
        configuration.setJdbcTypeForNull(JdbcType.NULL);
    }
}
