package com.iwin.controller;


import com.iwin.entity.SysUser;
import com.iwin.mapper.SysUserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author iwin
 * @since 2021-08-23
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserMapper sysUserMapper;

    @GetMapping("/getAll")
    public List<SysUser> getAll() {
        return sysUserMapper.selectList(null);
    }
}

