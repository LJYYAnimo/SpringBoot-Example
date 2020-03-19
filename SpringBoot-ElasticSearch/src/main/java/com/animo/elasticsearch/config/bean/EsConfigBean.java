package com.animo.elasticsearch.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 刘金泳
 * @Date 2019/11/11
 */
@ConfigurationProperties(prefix = "es")
@Component
@Data
public class EsConfigBean {

    private String connecteds;

}
