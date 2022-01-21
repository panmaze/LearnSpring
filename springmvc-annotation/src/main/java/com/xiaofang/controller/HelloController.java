package com.xiaofang.controller;

import com.xiaofang.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    HelloService helloService;

    @Autowired
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello...");
        return helloService.sayHello("tomcat...");
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
