package com.iwin;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootApolloApplication.class)
class SpringbootApolloApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(1111);
    }

    @Test
    public void testApollo() {
        Config config = ConfigService.getAppConfig();
        String property = config.getProperty("sms.enable", null);
        System.out.println(property);

    }

}
