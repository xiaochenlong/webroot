import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2016/1/4.
 */
public class scheulingTest {


    @Test
    public void t0(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
