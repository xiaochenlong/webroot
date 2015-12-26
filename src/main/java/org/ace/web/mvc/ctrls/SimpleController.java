package org.ace.web.mvc.ctrls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by xiaochenlong on 2015/12/26.
 */

@RestController
@RequestMapping("/simple")
public class  SimpleController{

    static final Logger logger = LoggerFactory.getLogger(SimpleController.class);


    @RequestMapping(value = "/str")
    public  String simple_str() {
        logger.debug("debug....");
        logger.info("info....");
        logger.warn("warn....");
        return "Hello world!";
    }


    @RequestMapping(value = {"/jo"},produces = {MediaType.APPLICATION_JSON_VALUE})
    public Model simple_json(Model model){
        logger.warn("json....");
        model.addAttribute("data",new Date());
        model.addAttribute("version",2);
        return  model;
    }

}
