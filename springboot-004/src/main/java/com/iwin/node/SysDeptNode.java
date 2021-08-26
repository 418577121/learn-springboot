package com.iwin.node;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iwin.entity.SysDept;
import com.iwin.utils.DataTree;

import java.util.List;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.node
 * @description: 构建部门节点数据
 * @author: DingHaiTing
 * @create_time: 2021-08-25 22:20
 **/

public class SysDeptNode extends SysDept implements DataTree<SysDeptNode, String> {

    @JsonIgnore // 忽略字段
    private String id;
    @JsonIgnore // 忽略字段
    private String parentId;
    private List<SysDeptNode> children;
    @Override
    public String getId() {
        return super.getDeptId();
    }

    @Override
    public String getParentId() {
        return super.getParDeptId();
    }

    @Override
    public void setChildren(List<SysDeptNode> children) {
          this.children = children;
    }

    @Override
    public List<SysDeptNode> getChildren() {
        return this.children;
    }
}
