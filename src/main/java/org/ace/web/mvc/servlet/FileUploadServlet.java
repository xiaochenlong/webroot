package org.ace.web.mvc.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * servlet 文件上传
 * Created by xiaochenlong on 2015/12/27.
 */

@WebServlet(urlPatterns={"/servlet/upload"})
public class FileUploadServlet extends HttpServlet {
    // 定义文件的上传路径
    private String uploadPath =null;
    @Override
    public void init() throws ServletException {
        uploadPath = "E:/logs/uploadfile";
    }
    // 限制文件的上传大小
    private int maxPostSize = 10000000 * 1024 * 1024;

    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Access !");
        System.out.println(uploadPath);
        // 防止中文乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 保存文件到服务器中
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(4096);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(maxPostSize);
        try {
            List fileItems = upload.parseRequest(request);
            Iterator iter = fileItems.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if(item.isFormField()){
                    //from field
                }else{
                    //file upload
                    String name = item.getName();
                    String fileName = item.getFieldName();
                    System.out.println(fileName+"..."+name);
                    try {
                        item.write(new File(uploadPath , name));
                        out.print("http://127.0.0.1:8080/img/"+name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "结束");
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
