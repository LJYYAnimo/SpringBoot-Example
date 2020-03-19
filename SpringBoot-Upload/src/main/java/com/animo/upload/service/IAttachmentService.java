package com.animo.upload.service;

import com.animo.upload.entity.AttachmentEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘金泳
 * @since 2020-03-19
 */
public interface IAttachmentService extends IService<AttachmentEntity> {

    Map<String,Object> upload(MultipartFile file);
}
