package com.animo.mybatisplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 刘金泳
 * @Date 2020/2/17
 */
@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
