package com.iwin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iwin.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.iwin.entity.vo.UserPageVO;
import com.iwin.entity.vo.UserVO;
import com.iwin.response.AjaxResponse;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author iwin
 * @since 2021-09-04
 */
public interface SysUserService extends IService<SysUser> {

    AjaxResponse addOAUser(SysUser sysUser);

    IPage<UserVO> selectPageUser(UserPageVO pageVO);
}
