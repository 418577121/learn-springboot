package com.iwin.controller;

import com.iwin.common.AjaxResponse;
import com.iwin.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

@Api(description = "用户接口",tags = {"标题"}, value = "测试")
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
 /*   @Operation(summary = "接口方法描述")
    @Parameters({
            @Parameter(name = "name", description = "学生姓名", required = true),
            @Parameter(name = "age", description = "学生年龄", required = true)
    })*/
    @ApiOperation(value = "接口方法描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "学生姓名", value = "name", dataType = "string",required = true)
    })
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
