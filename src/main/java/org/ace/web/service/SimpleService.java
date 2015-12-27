package org.ace.web.service;

import org.ace.web.bean.Simple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by xiaochenlong on 2015/12/27.
 */

public interface SimpleService {
    static final Logger logger = LoggerFactory.getLogger(SimpleService.class);

    Simple findByid(int id);
    int save(Simple simple);
    int update(Simple simple);
    List<Simple> list();
}
