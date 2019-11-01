//package com.animo.mybatis.service;
//
//import com.animo.mybatis.component.UserComponent;
//import com.animo.mybatis.entity.Nav;
//import com.animo.mybatis.entity.ext.NavExt;
//import com.animo.mybatis.mapper.NavMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cglib.core.DebuggingClassWriter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//class NavServiceTest {
//
//    @Autowired
//    private NavService navService;
//
//    @Autowired
//    private NavMapper navMapper;
//
//    @Autowired
//    private UserComponent userComponent;
//
//    @Test
//    void save() {
//        Nav nav = new Nav();
//        nav.setName("SpringBoot教程");
//        nav.setPid(0);
//        navService.save(nav);
//    }
//
//    @Test
//    void saveList(){
//        List<Nav> list = new ArrayList<>();
//        list.add(new Nav("2-1 核心特性介绍(03:25)",20));
//        list.add(new Nav("2-2 核心特性组件自动装配介绍 (09:10）",20));
//        list.add(new Nav("2-3 核心特性-组件自动装配工程部分 (07:18)",20));
//        list.add(new Nav("2-4 Web应用介绍（08:21）",20));
//        list.add(new Nav("2-5 Web应用特性 - 传统Servlet（09:28）",20));
//        navService.saveList(list);
//    }
//
//    @Test
//    void getByKey(){
//        List<NavExt> navExt = navService.getByKey("1");
//        System.out.println(navExt.toString());
//    }
//
//    @Test
//    void getById(){
//        Nav nav = navService.getById(3);
//        System.out.println(nav);
//    }
//
//    @Test
//    void transactionalTest(){
//        navService.transactionalTest(3);
//    }
//
//    @Test
//    void testsd(){
//        List<Nav> navs = navMapper.getByLikeTest(21);
//        System.out.println(navs.size());
//    }
//
//    @Test
//    void component(){
////        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/liujinyong/Documents/");
////        String name = userComponent.getName();
////        navService.test();
////        System.out.println(name);
//    }
//}