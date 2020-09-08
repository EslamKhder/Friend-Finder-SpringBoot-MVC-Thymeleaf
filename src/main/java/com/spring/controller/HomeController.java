package com.spring.controller;

import com.spring.dao.CommentRepository;
import com.spring.dao.FriendRepository;
import com.spring.dao.PostRepository;
import com.spring.dao.UserRepository;
import com.spring.model.Friend;
import com.spring.model.Post;
import com.spring.model.User;
import com.spring.util.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private FriendRepository friendRepository;
    private UserRepository userRepository;

    @Autowired
    public HomeController(PostRepository postRepository, CommentRepository commentRepository, FriendRepository friendRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.friendRepository = friendRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        return "/view/index";
    }

    @GetMapping("/home")
    public String showMyPage(Model model) {
        List<User> users;
        List<Friend> friends;
        model.addAttribute("posts",postRepository.findAll());
        if(UserData.isConnected()){
            List<Post> posts = postRepository.findByUser(new User(UserData.userId()));
            Collections.reverse(posts);
            model.addAttribute("myposts",posts);
            users = userRepository.findAll();
            friends = friendRepository.findByUser(new User(UserData.userId()));

            users = users.parallelStream().filter(x -> x.getId() != UserData.userId()).collect(Collectors.toList());
            if(!friends.isEmpty()){
                for (int i = 0; i< friends.size(); i++){
                    int finalI = i;
                    users = users.parallelStream().filter(x -> x.getId() != friends.get(finalI).getFriendid())
                                                  .collect(Collectors.toList());
                }
            }
            model.addAttribute("myfriends",users);
        }
        model.addAttribute("comments",commentRepository.findAll());
        model.addAttribute("imageprofile", UserData.userImage());
        model.addAttribute("post", new Post());
        model.addAttribute("users",userRepository.findAll());
        return "/view/mainpage";
    }
}