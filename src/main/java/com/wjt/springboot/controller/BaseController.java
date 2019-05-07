package com.wjt.springboot.controller;


 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    /*返回错误页面*/
    @RequestMapping("/404")
    public String error_404() {
        return "error";
    }

}
