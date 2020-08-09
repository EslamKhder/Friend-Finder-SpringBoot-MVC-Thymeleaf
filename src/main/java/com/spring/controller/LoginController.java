package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyForm")
    public String showMyLoginPage(Model model) {
        return "/view/userlogin";
    }
}
