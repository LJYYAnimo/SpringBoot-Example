package com.animo.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘金泳
 * @Date 2019/10/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nav {

    private Integer id;

    private String name;

    private Integer pid;

    private String des;

    private String key;

    public Nav(String name, Integer pid) {
        this.name = name;
        this.pid = pid;
    }

}



