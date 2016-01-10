package org.ace.web.scheuling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xiaochenlong on 2015/12/27.
 */

//@Component
public class SimpleJob {

    public SimpleJob() {
        System.out.println("构造函数。。。。");
    }

    public void run(){
        System.out.println("run..."+System.currentTimeMillis()/1000);
    }

    //@Scheduled(initialDelay=1000, fixedRate=5000)
    public void job(){
        System.out.println("job..."+System.currentTimeMillis()/1000);
    }
}
