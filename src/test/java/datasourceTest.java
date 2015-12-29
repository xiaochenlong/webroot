import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

}
