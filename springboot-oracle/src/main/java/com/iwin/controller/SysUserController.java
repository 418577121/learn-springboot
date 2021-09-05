package com.iwin.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.iwin.entity.SysUser;
import com.iwin.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.ObjectName;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author iwin
 * @since 2021-09-02
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private SysUserService service;


    @PostMapping("/add")
    public Object add(@RequestBody SysUser sysUser) {
        return   service.save(sysUser) == true ? "ok" : "no";
    }

    @GetMapping("/getOne")
    public Object one() {
     return    service.list(new LambdaQueryWrapper<SysUser>().eq(SysUser::getDeptId, "1111"));
    }
}

