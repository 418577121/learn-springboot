package com.iwin.controller;


import com.iwin.entity.SysDept;
import com.iwin.mapper.SysDeptMapper;
import com.iwin.node.SysDeptNode;
import com.iwin.utils.DataTreeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 部门信息，和单位多对一 前端控制器
 * </p>
 *
 * @author iwin
 * @since 2021-08-25f
 */
@RestController
//@RequestMapping("/sysDept")
public class SysDeptController {
    @Resource
    private SysDeptMapper sysDeptMapper;
    @GetMapping("/test")
    public List<SysDeptNode> test() {

        List<SysDept> tree = sysDeptMapper.getTree();
        System.out.println(tree);
        List<SysDeptNode> collect = tree.stream().map(item -> {
            SysDeptNode bean = new SysDeptNode();
            BeanUtils.copyProperties(item, bean);
            return bean;
        }).collect(Collectors.toList());
        System.out.println(collect);
        List<SysDeptNode> sysDeptNodes = DataTreeUtil.buildTree(collect, "40288ac45a3c1e8b015a3c28b4ae01d6");

       return sysDeptNodes;
    }
}

