package org.ace.web.scheuling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xiaochenlong on 2015/12/27.
 *
 * fixedDelay 上次结束到下次开始间隔（如果执行时间大于此值则执行结束就执行下一次）
 * fixedRate  上次开始到下次开始间隔
 */

@Component
public class SimpleJob {

    public SimpleJob() {
        System.out.println("构造函数。。。。");
    }

    public void run(){
       // System.out.println("run.00000000.."+System.currentTimeMillis()/1000);
    }

    @Scheduled(initialDelay=1000, fixedDelay = 3000)
    public void job(){
        System.out.println("job.11111111.."+System.currentTimeMillis()/1000);
        try {
            Thread.sleep(1000);
            System.out.println("vvvvvvvv");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(initialDelay=1000, fixedRate=5000)
    public void job2(){
        //System.out.println("job.2222222.."+System.currentTimeMillis()/1000);
    }
}
