package com.iwin.controller;


import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.iwin.entity.SysUser;
import com.iwin.entity.excel.UserExcel;
import com.iwin.entity.vo.UserPageVO;
import com.iwin.entity.vo.UserVO;
import com.iwin.response.AjaxResponse;
import com.iwin.service.SysUserService;
import com.iwin.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author iwin
 * @since 2021-09-04
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping("/addUser")
    public AjaxResponse addOAUser(@Valid @RequestBody SysUser sysUser) {
        return sysUserService.addOAUser(sysUser);
    }

    @GetMapping("/getPageUser")
    public AjaxResponse getPageUser(UserPageVO userPageVO) {
        return   AjaxResponse.success(sysUserService.selectPageUser(userPageVO));
    }

    @GetMapping("/exportUserData")
    public void exportUserData(HttpServletResponse response, UserPageVO userPageVO) {
        IPage<UserVO> userVOIPage = sysUserService.selectPageUser(userPageVO);
        List<UserVO> records = userVOIPage.getRecords();
        List<UserExcel> userExcels = new ArrayList<>();
        records.forEach(item -> {
            UserExcel userExcel = new UserExcel();
            BeanUtils.copyProperties(item,userExcel);
            userExcels.add(userExcel);
        });

        ExcelUtil.writeExcel(response, userExcels, "用户数据", ExcelTypeEnum.XLSX);
    }

}

