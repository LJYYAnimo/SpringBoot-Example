package com.animo.elasticsearch.config;

import com.animo.elasticsearch.config.bean.EsConfigBean;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @author 刘金泳
 * @Date 2019/11/11
 */
@Configuration
public class ElasticConnectedConfig extends AbstractElasticsearchConfiguration {

    @Autowired
    EsConfigBean esConfigBean;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(esConfigBean.getConnecteds().split(","))
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

}
