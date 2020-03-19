package com.animo.upload.service.impl;

import com.animo.upload.entity.AttachmentEntity;
import com.animo.upload.mapper.AttachmentMapper;
import com.animo.upload.service.IAttachmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘金泳
 * @since 2020-03-19
 */
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, AttachmentEntity> implements IAttachmentService {

    @Value("${uploadFile.location}")
    private String location;


    @Override
    public Map<String,Object> upload(MultipartFile file) {
        // 主键KEY
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 文件名称包括后缀
        String fileName = file.getOriginalFilename();
        //
        int pointIndex =  fileName.lastIndexOf(".");
        // 文件后缀
        String fileSuffix = fileName.substring(pointIndex);
        // 获取当前时间戳
        String fileAlias = System.currentTimeMillis()+"";
        // 保存到本地的文件名称
        String saveFileName = fileAlias.concat(fileSuffix);
        File savedFile = new File(location,saveFileName);
        try {
            // 把上传过来的文件拷贝到本地新文件
            FileUtils.copyInputStreamToFile(file.getInputStream(),savedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AttachmentEntity attachmentEntity = new AttachmentEntity();
        attachmentEntity.setId(uuid);
        attachmentEntity.setFileName(fileName);
        attachmentEntity.setFileAlias(saveFileName);
        attachmentEntity.setContentType(file.getContentType());
        baseMapper.insert(attachmentEntity);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        return map;
    }
}
