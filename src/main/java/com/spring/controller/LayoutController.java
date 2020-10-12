package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {

    @RequestMapping("/lay")
    public String layout(){
        return "/layouts/layout";
    }
    @RequestMapping("/take")
    public String test(){
        return "/layouts/test";
    }
}
