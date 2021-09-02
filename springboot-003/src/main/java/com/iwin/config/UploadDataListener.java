package com.iwin.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.iwin.entity.UploadData;
import com.iwin.exception.CustomException;
import com.iwin.exception.CustomExceptionType;
import com.iwin.mapper.UploadDAO;
import com.iwin.service.ReadExcelService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
@Slf4j
// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class UploadDataListener extends AnalysisEventListener<UploadData> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 3000;
    List<UploadData> list = new ArrayList<UploadData>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private ReadExcelService readExcelService;

    public UploadDataListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
       //  uploadDAO = new UploadDAO();
    }

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param uploadDAO
     */
    public UploadDataListener(ReadExcelService readExcelService) {
        this.readExcelService = readExcelService;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(UploadData data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        if (data.getString().equals("字符串3")) {
            throw new CustomException(CustomExceptionType.OTHER_ERROR,"第" + list.size() +"出错");
        }
        // 这里校验excel列信息
        list.add(data);

        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
   /*     if (list.size() >= BATCH_COUNT) {
           // saveData();
            readExcelService.save(list);
            // 存储完成清理 list
            list.clear();
        }
        readExcelService.save(list);
        list.clear();*/

    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
       // saveData();
        readExcelService.save(list);
        list.clear();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        readExcelService.save(list);
        log.info("存储数据库成功！");
    }

    /**
     * 这里会一行行的返回头
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        // 这里校验头信息
        /*if (!(headMap.get(0) == "字符串标题")) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,"标题: 第 1"  +"出错");
        }*/
        for (Integer key:headMap.keySet()) {
             if (!headMap.get(key) .equals(InitExcelHeadConfig.head.get(key))) {
                 throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,"标题: 第" +(key +1 ) +"出错");
             }
        }
        log.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
    }

}