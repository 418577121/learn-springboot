package com.iwin;

import com.iwin.controller.StudentController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@Slf4j
public class Springboot001ApplicationTests {

    private static MockMvc mockMvc;

    @BeforeAll
    static void setUP() {
        Object[] controllers;
        mockMvc = MockMvcBuilders.standaloneSetup(new StudentController()).build();
    }

    @Test
    public void saveStudent() throws Exception {
        String student = "{\n" +
                "        \"name\": \"dht\",\n" +
                "        \"id\": 1,\n" +
                "        \"createTime\": \"2021/08/16 16:25:33\"\n" +
                "    }";
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/student")
                        .contentType("application/json")
                        .content(student)
        ) //.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("dht"))
                .andDo(print()).andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void contextLoads() {
        System.out.println(LocalDateTime.now());
    }

}
