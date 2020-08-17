package com.spring.controller;

import com.spring.dao.UserRepository;
import com.spring.model.Role;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class UserController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") User user) {

        //Encode Password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // set user active
        user.setActive(1);

        // Set Role Of User
        Role role = new Role();
        role.setId((long) 1);
        Set<Role> ro = new HashSet<>();
        ro.add(role);
        user.setRoles(ro);

        // save the user
        userRepository.save(user);

        // use a redirect to prevent duplicate submissions
        //return "redirect:/userlogin";
        return "redirect:/login";
    }
}
