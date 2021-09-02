package com.iwin.service;

import com.iwin.entity.UploadData;
import com.iwin.mapper.ExcelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.service
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-20 00:37
 **/

@Service
public class ReadExcelServiceImpl implements ReadExcelService {

    @Resource
    private ExcelMapper excelMapper;
    @Override
    @Transactional
    public void save(List<UploadData> list) {
        excelMapper.save(list);
    }
}
