package com.animo.fastdfs.controller;

import com.animo.fastdfs.service.FastDFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 刘金泳
 * @Date 2019/11/1
 */
@RestController
@RequestMapping("/fastdfs")
public class FastDFSController {

    @Autowired
    private FastDFSService fastDFSService;

    @GetMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        return fastDFSService.upload(file);
    }

}
