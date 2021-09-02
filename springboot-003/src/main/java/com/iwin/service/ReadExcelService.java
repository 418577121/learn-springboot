package com.iwin.service;

import com.iwin.entity.UploadData;

import java.util.List;

/**
 * @project_name: learn-springboot
 * @package_name: com.iwin.service
 * @description:
 * @author: DingHaiTing
 * @create_time: 2021-08-20 00:37
 **/

public interface ReadExcelService {
    void save(List<UploadData> list);
}
