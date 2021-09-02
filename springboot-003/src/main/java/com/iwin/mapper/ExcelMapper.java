package com.iwin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iwin.entity.Article;
import com.iwin.entity.UploadData;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.mapper
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-20 00:38
 **/
@Mapper
public interface ExcelMapper {
    void save(List<UploadData> list);
}
