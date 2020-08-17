package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mainPage(Model model) {
        return "/view/index";
    }
    @GetMapping("/home")
    public String showMyLoginPage(Model model) {
        return "/view/mainpage";
    }
}