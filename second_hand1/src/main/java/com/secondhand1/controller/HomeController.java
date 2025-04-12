package com.secondhand1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanghang
 * @date 2025/3/18
 * @Description
 */
@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "欢迎访问二手商品交易平台";
    }

}
