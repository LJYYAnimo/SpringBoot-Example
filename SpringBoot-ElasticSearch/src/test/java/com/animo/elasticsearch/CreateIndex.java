package com.animo.elasticsearch;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author 刘金泳
 * @Date 2019/11/11
 */
@SpringBootTest
public class CreateIndex {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void createIndex(){

    }

}
