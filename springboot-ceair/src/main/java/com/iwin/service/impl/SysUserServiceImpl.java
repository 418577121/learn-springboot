package com.iwin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iwin.entity.SysDept;
import com.iwin.entity.SysUser;
import com.iwin.entity.vo.UserPageVO;
import com.iwin.entity.vo.UserVO;
import com.iwin.exception.CustomExceptionType;
import com.iwin.mapper.SysDeptMapper;
import com.iwin.mapper.SysUserMapper;
import com.iwin.response.AjaxResponse;
import com.iwin.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author iwin
 * @since 2021-09-04
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysDeptMapper sysDeptMapper;

    @Resource
    private SysUserService sysUserService;
    @Override
    public AjaxResponse addOAUser(SysUser sysUser) {
        int insert = sysUserMapper.insert(sysUser);
        return insert > 0 ? AjaxResponse.success() : AjaxResponse.error(CustomExceptionType.ADD_ERROR);
    }

    @Override
    public IPage<UserVO> selectPageUser(UserPageVO pageVO) {
        Page<SysUser> page = new Page<>(pageVO.getPageNum(),pageVO.getPageSize());
        // pageVO.setUserName(pageVO.get); 去空格一些处理
        pageVO.setLoginName("%" + pageVO.getLoginName() + "%");
        IPage<UserVO> userVOIPage = sysUserMapper.selectPageUser(page, pageVO);
        for (UserVO  userVO : userVOIPage.getRecords()) {
            // 根据部门名称查询父部门
            if (!userVO.getParentId().equals("-1")) {
                // 当前部门信息
                SysDept sysDept = sysDeptMapper.selectOne(new LambdaQueryWrapper<SysDept>()
                        .eq(SysDept::getDeptName, userVO.getDeptName())
                        .apply("rowNum = 1"));

                SysDept parentDept = sysDeptMapper.selectOne(new LambdaQueryWrapper<SysDept>()
                        .eq(SysDept::getDeptId, sysDept.getParentId())
                        .apply("rowNum = 1"));
                userVO.setDeptName(parentDept.getDeptName() + "-" + userVO.getDeptName());
                if (!parentDept.getParentId().equals("-1")) {
                    SysDept parentParentDept = sysDeptMapper.selectOne(new LambdaQueryWrapper<SysDept>()
                            .eq(SysDept::getDeptId, sysDept.getParentId())
                            .apply("rowNum = 1"));
                userVO.setDeptName(parentParentDept.getDeptName() + "-" + userVO.getDeptName());
                }
            }


        }
        return userVOIPage;
    }

}
