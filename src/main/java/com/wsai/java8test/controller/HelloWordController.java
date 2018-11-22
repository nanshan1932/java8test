package com.wsai.java8test.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@EnableAutoConfiguration
public class HelloWordController {

    @RequestMapping(value = "/hello")
    public String index(){
        return "Hello World!";
    }

    @RequestMapping(value = "/testHotFix")
    public void testHotFixBranch(){
        System.out.println("yyyyyy");
    }


    @RequestMapping(value = "/dev2")
    public void dev2(){
    }
}
