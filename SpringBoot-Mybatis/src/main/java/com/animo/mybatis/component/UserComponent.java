package com.animo.mybatis.component;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 刘金泳
 * @Date 2019/10/28
 */
@Component
@Data
public class UserComponent {

    private String name = "组件";

}
