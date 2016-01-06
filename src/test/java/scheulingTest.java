import backtype.storm.utils.DRPCClient;
import org.apache.thrift7.TException;
import org.apache.thrift7.transport.TTransportException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/4.
 */
public class scheulingTest {

    private static String spoutName="manualDRPC";

    @Test
    public void t0(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        try {
            DRPCClient client = context.getBean(DRPCClient.class);
            String userstr = client.execute(spoutName, "/user/123");
            System.out.println(userstr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t2()  {
        try{
            Map<String, Object> conf = new HashMap<String, Object>();
            conf.put("storm.thrift.transport", "backtype.storm.security.auth.SimpleTransportPlugin");
            conf.put("storm.nimbus.retry.times", 3);
            conf.put("storm.nimbus.retry.interval.millis", 10000);
            conf.put("storm.nimbus.retry.intervalceiling.millis", 3000);
            conf.put("drpc.max_buffer_size", 1048576);
            DRPCClient client = new DRPCClient(conf, "192.168.3.160", 3772, 3000);
            String DRPCSpout = "manualDRPC";
            String userstr = client.execute(DRPCSpout, "/user/123");
            String cheapstr = client.execute(DRPCSpout, "/cheap/123");
            System.out.println(userstr + "...." + cheapstr);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
