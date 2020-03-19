package com.animo.upload.controller;


import com.animo.upload.entity.AttachmentEntity;
import com.animo.upload.service.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘金泳
 * @since 2020-03-19
 */
@Controller
@RequestMapping("/attachment")
public class AttachmentController {

    @Value("${uploadFile.location}")
    private String location;


    @Autowired
    private IAttachmentService attachmentService;

    @PostMapping("/upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile file){
        return attachmentService.upload(file);
    }

    @GetMapping("/download/{id}")
    public void getFile(@PathVariable("id")String id, HttpServletResponse response){
        AttachmentEntity attachmentEntity = attachmentService.getById(id);
        File file = new File(location + attachmentEntity.getFileAlias());
        try {
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType(attachmentEntity.getContentType());
            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(attachmentEntity.getFileName(), "UTF-8"));
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/listData")
    @ResponseBody
    public Map<String,Object> listData(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",1000);
        map.put("data",attachmentService.list());
        return map;
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }

}
