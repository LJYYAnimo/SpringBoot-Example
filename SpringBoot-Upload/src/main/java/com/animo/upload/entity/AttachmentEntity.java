package com.animo.upload.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 刘金泳
 * @since 2020-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("attachment")
public class AttachmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId("id")
    private String id;

    /**
     * 磁盘文件名称
     */
    @TableField("file_alias")
    private String fileAlias;

    /**
     * 源文件名称
     */
    @TableField("file_name")
    private String fileName;

    /**
     * 文件类型
     */
    @TableField("content_type")
    private String contentType;


}
