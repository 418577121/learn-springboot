package com.iwin.service.impl;

import com.iwin.entity.SysDept;
import com.iwin.mapper.SysDeptMapper;
import com.iwin.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门信息，和单位多对一 服务实现类
 * </p>
 *
 * @author iwin
 * @since 2021-08-25
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

}
