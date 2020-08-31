package com.spring.controller;

import com.spring.dao.CommentRepository;
import com.spring.dao.PostRepository;
import com.spring.model.Post;
import com.spring.util.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    @Autowired
    public HomeController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        return "/view/index";
    }

    @GetMapping("/home")
    public String showMyPage(Model model) {
        model.addAttribute("posts",postRepository.findAll());
        model.addAttribute("comments",commentRepository.findAll());

        model.addAttribute("imageprofile", UserData.userImage());
        model.addAttribute("post", new Post());

        return "/view/mainpage";
    }
}