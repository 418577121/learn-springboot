package com.iwin.controller;

import com.iwin.common.AjaxResponse;
import com.iwin.entity.Student;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.controller
 * @description: 学生控制层
 * @author: DingHaiTing
 * @create_time: 2021-08-16 11:00
 **/
@Slf4j
@RestController
public class StudentController {

    @GetMapping("/student/{id}")
    public AjaxResponse getStudent(@PathVariable("id") Long id) {
        Student student = new Student(1L,"dht",null, new Date());
        log.info("student " + student);

        return AjaxResponse.success(student);
    }
    @GetMapping("/students/{id}")
    public AjaxResponse getStudentExcel(@PathVariable("id") Long id) {
        Student student = new Student();
        log.info("student " + student);

        return AjaxResponse.success(student);
    }
    @PostMapping("/student")
    public AjaxResponse saveStudent(@RequestBody Student student) {

        log.info("student " + student);

        return AjaxResponse.success(student);
    }

    @PutMapping("/student")
    public AjaxResponse updateStudent(@RequestBody Student student) {

        if (student.getId() == null) {

        }
        log.info("student " + student);

        return AjaxResponse.success();
    }


    @DeleteMapping("/student/{id}")
    public AjaxResponse updateStudent(@PathVariable("id") Long id) {

        if (id == null) {

        }
        log.info("student " + id);

        return AjaxResponse.success();
    }

}
