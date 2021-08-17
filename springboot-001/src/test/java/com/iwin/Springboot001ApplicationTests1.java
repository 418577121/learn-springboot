package com.iwin;

import com.iwin.controller.StudentController;
import com.iwin.entity.Employee;
import com.iwin.entity.School;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
    @Test
    public void testProperties() {
        System.out.println(school);
        System.out.println(ioc.containsBean("testService"));
        System.out.println(employee);
    }

}
