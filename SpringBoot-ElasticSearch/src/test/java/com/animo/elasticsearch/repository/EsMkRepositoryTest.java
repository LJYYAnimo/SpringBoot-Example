package com.animo.elasticsearch.repository;

import com.animo.elasticsearch.bean.EsMk;

import org.elasticsearch.index.query.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;

import java.util.Date;

@SpringBootTest
class EsMkRepositoryTest {

    @Autowired
    private EsMkRepository esMkRepository;

    @Test
    public void save(){
        EsMk esMk = new EsMk();
        esMk.setName("Python接口自动化测试框架实战 从设计到开发");
        esMk.setDescription("课程从接口基础知识入门，从抓包开始，到接口工具的运用，再到常见接口库、接口开发、Mock服务、unittest框架的运用，再讲解接口测试框架的设计、开发以及持续集成， 最后再通过开发一套前后端解耦过程中需要用到的桩服务来完成我们整个接口自动化测试框架的学习。");
        esMk.setNumber(374);
        esMk.setPrice(299.00F);
        esMk.setOldPrice(299.00F);
        esMk.setId(System.currentTimeMillis()+"");
        esMk.setCreatedTime(new Date());
        esMkRepository.save(esMk);
    }

    @Test
    public void TermQuerySearch(){
        //精确查询不分词 单
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("description","讲师风趣幽默");
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(termQueryBuilder);
        //需要显示的字段
        String[] includes = {"name","description"};
        FetchSourceFilter fetchSourceFilter = new FetchSourceFilter(includes,null);
        nativeSearchQuery.addSourceFilter(fetchSourceFilter);
//        //设置排序
//        List<Sort.Order> orders = new ArrayList<>();
//        orders.add(new Sort.Order(Sort.Direction.DESC,"price"));
//        Sort sort = Sort.by(orders);
//        nativeSearchQuery.addSort(sort);

        Page<EsMk> page = esMkRepository.search(nativeSearchQuery);

        System.out.println(page);
    }

    @Test
    public void MatchQuerySearch(){
       MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("description","讲师风趣幽默");
       NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(matchQueryBuilder);
        String[] includes = {"name","description"};
        FetchSourceFilter fetchSourceFilter = new FetchSourceFilter(includes,null);
        nativeSearchQuery.addSourceFilter(fetchSourceFilter);
        Page<EsMk> iterable = esMkRepository.search(nativeSearchQuery);
        System.out.println(iterable);
    }



    @Test
    public void deleteAll(){
        esMkRepository.deleteAll();
    }

}