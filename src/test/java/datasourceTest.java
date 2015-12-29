import org.ace.web.bean.Demo;
import org.ace.web.bean.Simple;
import org.ace.web.dao.inter.SimpleDao;
import org.ace.web.service.SimpleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Administrator on 2015/12/29.
 */
public class datasourceTest {

    @Test
    public void t1() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource up = context.getBean(DataSource.class);
        Connection conn = up.getConnection();
        conn.setAutoCommit(false);
        Statement stm = conn.createStatement();
        boolean i = stm.execute("insert into tb_simple(NAME) VALUES ('xiaochenlong')");
        conn.commit();
        conn.close();
        System.out.println(up);
    }

    @Test
    public void t2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleDao dao = context.getBean(SimpleDao.class);
        Simple s = new Simple();
        s.setName("ether008");

        int z = dao.save(s);
        System.out.println(z);
        //List<Simple> list = dao.list();
        //System.out.println(list);
    }

    @Test
    public void t3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleService service = context.getBean(SimpleService.class);
        List<Simple> list = service.list();
        System.out.println(list);
    }
}
