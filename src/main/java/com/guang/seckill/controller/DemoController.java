package com.guang.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class DemoController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg"," world");
        return "hello";
    }
}
