package com.iwin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iwin.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iwin.entity.vo.UserPageVO;
import com.iwin.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author iwin
 * @since 2021-09-04
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    // 根据条件分页查询
    IPage<UserVO> selectPageUser(Page<SysUser> page, UserPageVO userPageVO);
}
