package com.spring.controller;

import com.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    /*@GetMapping("/mainprofile")
    public String mainPage() {
        return "view/mainpage";
    }
     */

    @GetMapping("/login")
    public String showMyLoginPage() {
        return "view/userlogin";
    }
    @GetMapping("/signup")
    public String newAccount(Model model) {
        model.addAttribute("user", new User());
        return "view/usernewaccount";
    }
}
