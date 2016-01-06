package org.ace.web.service.impl;

import org.ace.web.bean.Simple;
import org.ace.web.service.SimpleService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by xiaochenlong on 2015/12/27.
 */

@Service
public class SimpleServiceImpl implements SimpleService {


    public Simple findByid(int id) {
        return null;
    }

    public int save(Simple simple) {

        logger.warn("SimpleServiceImpl save....");
        if (StringUtils.isEmpty(simple.getName())) {
            return 0;
        }
        return 0;
    }

    public int update(Simple simple) {
        int id = simple.getId();
        Simple os = this.findByid(id);
        if (os != null && StringUtils.isEmpty(simple.getName())) {
            return 0;
        }
        return 0;
    }

    public List<Simple> list() {
        return null;

    }

}
