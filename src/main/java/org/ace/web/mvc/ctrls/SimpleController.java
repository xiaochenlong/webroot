package org.ace.web.mvc.ctrls;

import org.ace.web.bean.Simple;
import org.ace.web.service.SimpleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by xiaochenlong on 2015/12/26.
 */

@RestController
@RequestMapping("/simple")
public class  SimpleController{

   private  static final Logger logger = LoggerFactory.getLogger(SimpleController.class);


    @Autowired
    private SimpleService service;

    @RequestMapping(value = "/reg",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Model register(Model model,Simple simple){
        int ret = service.save(simple);
        model.addAttribute("saveret",ret);
        return model;
    }

    @RequestMapping(value = "/str")
    public  String simple_str() {
        System.out.println(logger);
        logger.debug("debug....");
        logger.info("info....");
        logger.warn("warn....");
        return "Hello world!";
    }


    @RequestMapping(value = {"/jo"},produces = {MediaType.APPLICATION_JSON_VALUE})
    public Model simple_json(Model model){
        int r = service.save(null);
        logger.debug("debug....");
        logger.info("info....");
        logger.warn(r+".warn....");
        model.addAttribute("data",new Date());
        model.addAttribute("version",2);
        return  model;
    }


    /**
     * 单个文件上传
     * @param file
     * @param model
     * @return
     */
    @RequestMapping(value = "/upload",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Model simple_fileupload(@RequestParam MultipartFile file, Model model) {
        logger.warn("warn....");
        model.addAttribute("date",new Date());
        model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
        return model;
    }


    /**
     * 多个文件上传
     * @param file
     * @param model
     * @param simple
     * @return
     */
    @RequestMapping(value = "/uploads",produces = {MediaType.APPLICATION_JSON_VALUE})
    public  Model simple_fileuploads(@RequestParam MultipartFile[] file, Model model,Simple simple) {
        logger.warn("warn....");
        model.addAttribute("date",new Date());
        for(MultipartFile f:file){
            model.addAttribute(f.getOriginalFilename(),f.getName());
        }
        simple.setName("xiaochenlong");
        return model;
    }


}
