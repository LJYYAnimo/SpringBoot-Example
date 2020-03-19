package com.animo.elasticsearch.repository;

import com.animo.elasticsearch.bean.EsMk;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 刘金泳
 * @Date 2019/11/14
 */
@Repository
public interface EsMkRepository extends ElasticsearchRepository<EsMk,String> {
}
