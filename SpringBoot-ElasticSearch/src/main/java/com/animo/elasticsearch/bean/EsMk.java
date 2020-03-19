package com.animo.elasticsearch.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author 刘金泳
 * @Date 2019/11/14
 */
@Data
@Document(indexName = "es_mk",type = "mk",shards = 1,replicas = 0)
public class EsMk {
    @Id
    private String id;
    /**
     * 标题字段
     * name字段数据使用ik_max_word分析（细粒度）
     * 搜索的时候使用ik_smart（粗粒度）
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String name;
    /**
     * 描述字段
     * 同上面标题字段
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String description;
    /**
     * 编号字段
     */
    @Field(type = FieldType.Keyword)
    private Integer number;
    /**
     * 价格
     */
    @Field(type = FieldType.Float)
    private Float price;
    /**
     * 旧价格
     */
    @Field(type = FieldType.Float)
    private Float oldPrice;
    /***
     * 新增时间 自定义
     */
    @Field(type = FieldType.Date,format = DateFormat.custom,pattern = "yyyy‐MM‐dd HH:mm:ss||yyyy‐MM‐dd||epoch_millis")
    private Date createdTime;

}
