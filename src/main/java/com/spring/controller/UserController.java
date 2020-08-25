package com.spring.controller;

import com.spring.dao.UserRepository;
import com.spring.model.Role;
import com.spring.model.User;
import com.spring.util.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class UserController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @InitBinder
    public void initBinder(WebDataBinder webBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        webBinder.registerCustomEditor(String.class, ste);
    }

    @PostMapping("/register")
    public String addUser(@Valid @ModelAttribute("user") User user,
                          BindingResult theBindingResult,
                          @RequestParam("imagepro") MultipartFile multipartFile,
                          RedirectAttributes redirectAttributes,
                          Errors error) throws IOException {


        System.out.println(user.getImage());
        if (theBindingResult.hasErrors()) {
            return "view/usernewaccount";
        } else {
            if (userRepository.findByEmail(user.getEmail()) != null) {
                redirectAttributes.addFlashAttribute("existemail","Email Exist");
                return "redirect:/signup";
            } else {
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

                // copy image in local (your Computer)
                Image.saveImage(multipartFile);

                // set name of image in mosel User
                user.setImage(multipartFile.getOriginalFilename());

                // save the user
                userRepository.save(user);

                return "redirect:/login";
            }
        }

    }
}