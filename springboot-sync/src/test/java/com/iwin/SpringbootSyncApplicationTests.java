package com.iwin;

import com.iwin.aync.AsyncCallBackTask;
import com.iwin.aync.AsyncExecutorTask;
import com.iwin.aync.SyncTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

@SpringBootTest
class SpringbootSyncApplicationTests {

    @Test
    void contextLoads() {
        System.out.println();
    }
    @Autowired
    private SyncTask task;

    @Test
    public void testSyncTasks() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

    @Autowired
    private AsyncCallBackTask asyncCallBackTask;

    @Test
    public void testAsyncCallbackTask() throws Exception {
        long start = currentTimeMillis();
        Future<String> task1 = asyncCallBackTask.doTaskOneCallback();
        Future<String> task2 = asyncCallBackTask.doTaskTwoCallback();
        Future<String> task3 = asyncCallBackTask.doTaskThreeCallback();

        // 三个任务都调用完成，退出循环等待
        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
            sleep(1000);
        }

        long end = currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
    @Autowired
    private AsyncExecutorTask tasks;

    @Test
    public void testAsyncExecutorTask() throws Exception {
        tasks.doTaskOneCallback();
        tasks.doTaskTwoCallback();
        tasks.doTaskThreeCallback();

        sleep(30 * 1000L);
    }
}
