package com.animo.fastdfs.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 刘金泳
 * @Date 2019/11/1
 */
@Component
@ConfigurationProperties(prefix = "fastdfs")
@Data
public class FastDFSBean {


    private int connectTimeoutInSeconds;

    private int networkTimeoutInSeconds;

    private String charset;

    private String trackerServers;

}
