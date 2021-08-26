package com.iwin.mapper;

import com.iwin.entity.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 部门信息，和单位多对一 Mapper 接口
 * </p>
 *
 * @author iwin
 * @since 2021-08-25
 */

public interface SysDeptMapper extends BaseMapper<SysDept> {

/*    @Select("select  t.dept_id, t.dept_name, t.dept_code, t.par_dept_id,  level\n" +
            "from  SYS_DEPT t\n" +
            "start  with  t.dept_id =  '40288ac45a3c1e8b015a3c28b4ae01d6'\n" +
            "connect  by  prior  t.dept_id = t.par_dept_id\n" +
            "order  by  level , t.dept_code\n")*/
    @Select("select * from   SYS_DEPT ")
    List<SysDept>  getTree();
}
