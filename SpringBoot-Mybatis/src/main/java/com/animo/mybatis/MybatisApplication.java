package com.animo.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;

@SpringBootApplication
@MapperScan("com.animo.mybatis.mapper")
public class MybatisApplication {

    public static void main(String[] args) {
        System.out.println("启动类");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "target/cglib");
        SpringApplication.run(MybatisApplication.class, args);
    }

}
