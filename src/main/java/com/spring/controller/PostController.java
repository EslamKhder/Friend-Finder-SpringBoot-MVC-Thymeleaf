package com.spring.controller;

import com.spring.dao.PostRepository;
import com.spring.model.Post;
import com.spring.model.User;
import com.spring.springsecurity.config.userdetailsconfigration.UserPrincipal;
import com.spring.util.Image;
import com.spring.util.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class PostController {

    private PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping("/main")
    public String createPost(@ModelAttribute("post") Post post,
                             @RequestParam("file") MultipartFile multipartFile,
                             RedirectAttributes redirectAttributes) throws Exception {

        if(post.getText().isEmpty() && multipartFile.isEmpty()){
            redirectAttributes.addFlashAttribute("emptypost","Empty Post");
            return "redirect:/home";
        } else {
            if(!multipartFile.isEmpty()){
                // copy image in local (your Computer)
                Image.saveImage(multipartFile);
                // save name of image in database
                post.setImage(multipartFile.getOriginalFilename());
            }
            long id = UserData.userId();
            post.setUser(new User(id));
            postRepository.save(post);
            return "view/mainpage";
        }
    }
}