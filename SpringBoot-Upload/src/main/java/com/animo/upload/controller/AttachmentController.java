package com.animo.upload.controller;


import com.animo.upload.service.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘金泳
 * @since 2020-03-19
 */
@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    private IAttachmentService attachmentService;

    @PostMapping("/upload")
    public Map<String,Object> upload(MultipartFile file){
        return attachmentService.upload(file);
    }

}
