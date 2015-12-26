package org.ace.web.mvc.ctrls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by xiaochenlong on 2015/12/26.
 */

@Controller
@RequestMapping
public class JspController {

    static final Logger logger = LoggerFactory.getLogger(JspController.class);

    
    @RequestMapping(value = "/jsp")
    public  String simple_str(Model model) {
        logger.debug("debug....");
        logger.info("info....");
        logger.warn("warn....");
        model.addAttribute("date",new Date());
        return "simple";
    }


}
