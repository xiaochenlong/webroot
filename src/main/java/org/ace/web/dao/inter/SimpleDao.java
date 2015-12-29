package org.ace.web.dao.inter;

import org.ace.web.bean.Simple;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * Created by xiaochenlong on 2015/12/27.
 */
public interface SimpleDao {


    @Insert("insert into tb_simple(NAME) VALUES (#{name,jdbcType=VARCHAR})")
    int save(Simple simple);

    int update(Simple simple);

    Simple findById(int id);

    List<Simple> list();
}
