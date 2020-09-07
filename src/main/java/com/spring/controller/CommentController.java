package com.spring.controller;

import com.spring.dao.CommentRepository;
import com.spring.dao.PostRepository;
import com.spring.model.Comment;
import com.spring.model.User;
import com.spring.util.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class CommentController {

    private CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("/comment")
    @ResponseBody
    public String createComment(@RequestBody Comment comment){

        if(comment.getText().isEmpty()){
            return "invalid";
        } else {
            comment.setUser(new User(UserData.userId()));
            commentRepository.save(comment);
            return "success";
        }
    }

}