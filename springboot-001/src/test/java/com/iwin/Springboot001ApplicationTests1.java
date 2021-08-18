package com.iwin;

import com.iwin.controller.StudentController;
import com.iwin.entity.Employee;
import com.iwin.entity.Person;
import com.iwin.entity.School;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(classes = Springboot001Application.class)
public class Springboot001ApplicationTests1 {

    @Resource
    private School school;

    @Resource
    private ConfigurableApplicationContext ioc;

    @Resource
    private Employee employee;

    @Autowired
    private StringEncryptor encryptor;
    @Test
    public void testProperties() {
        System.out.println(school);
        System.out.println(ioc.containsBean("testService"));
        System.out.println(employee);
    }
    @Test
    public void testPassword() {
        /**
         * 测试jasypt加密解密
         */
        String password = "清华";
        String encryptPwd = encryptor.encrypt(password);
        System.out.println("加密:：" + encryptPwd);
        String decrypt = encryptor.decrypt("icfpi+TeRVOnq2lkw7QGqg==");
        System.out.println(decrypt);
    }

    @Test
    public void test2121() {
        Person person = new Person();
        person.setId(1);
        person.setName("iwin");
        person.setCreateTime(LocalDateTime.now());
        System.out.println(person);
    }
}
