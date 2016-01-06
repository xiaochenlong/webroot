package org.ace.web.mvc.ctrls;

import backtype.storm.utils.DRPCClient;
import org.apache.thrift7.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/1/6.
 */

@RestController
public class DrpcController {

    private  static final Logger logger = LoggerFactory.getLogger(DrpcController.class);

    @Autowired
    private DRPCClient client;

    private static String spoutName="manualDRPC";

    @RequestMapping(value = {"/drpc/index"},produces = {MediaType.APPLICATION_JSON_VALUE})

    public Model drpc_index(Model model){
        try {
            logger.info("test drpc....");
            String userstr = client.execute(spoutName, "/user/123");
            String cheapstr = client.execute(spoutName, "/cheap/123");
            model.addAttribute("user",userstr);
            model.addAttribute("cheap",cheapstr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}
